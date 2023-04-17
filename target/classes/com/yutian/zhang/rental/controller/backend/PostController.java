package com.yutian.zhang.rental.controller.backend;

import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.enums.PostTypeEnum;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.Post;
import com.yutian.zhang.rental.service.PostService;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

/**
 * Post Controller
 *
 * @author Yutian Zhang
 * @date 26/01/2022 17:27
 */
@Controller("backPostController")
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    /**
     * Post management
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/post")
    public String allPost(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                          @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                          Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Post condition = new Post();
        // Check if it is admin
        if (!loginUserIsAdmin()) {
            condition.setUserId(getLoginUserId());
        }
        Page<Post> postPage = postService.findAll(page, condition);
        for (Post temp : postPage.getRecords()) {
            temp.setUser(userService.get(temp.getUserId()));
        }

        model.addAttribute("pageInfo", postPage);

        model.addAttribute("tab", "post-list");
        model.addAttribute("pagePrefix", "/admin/post?");

        return "admin/post-list";
    }


    /**
     * Post
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/post/publish")
    public String publish(@RequestParam(value = "id", required = false) Long id, Model model) {
        Post post;
        if (id != null) {
            // No such a post
            post = postService.get(id);
            if (post == null) {
                return this.renderNotFound();
            }
            // No permission to view
            if (!loginUserIsAdmin() && !Objects.equals(post.getUserId(), getLoginUserId())) {
                return this.renderNotAllowAccess();
            }
        } else {
            post = new Post();
        }
        model.addAttribute("post", post);
        model.addAttribute("tab", "post-publish");
        return "admin/post-publish";
    }


    /**
     * Post submit
     *
     * @return
     */
    @RequestMapping(value = "/admin/post/publish/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult publishSubmit(Post post, HttpSession session) {
        try {
            // Set user id
            if (post.getId() == null) {
                post.setCreateTime(new Date());
                post.setUserId(getLoginUserId());
                post.setPostType(PostTypeEnum.SEEK_FOR_RENT.getValue());
            }
            // Get summary of the content
            int postSummary = 300;
            String summaryText = HtmlUtil.cleanHtmlTag(post.getContent());
            if (summaryText.length() > postSummary) {
                String summary = summaryText.substring(0, postSummary);
                post.setSummary(summary);
            } else {
                post.setSummary(summaryText);
            }
            post.setContent(HtmlUtil.cleanHtmlTag(post.getContent()));
            postService.insertOrUpdate(post);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Post fail");
        }
        return JsonResult.success("Post success", post.getId());
    }


    /**
     * Delete post
     *
     * @return
     */
    @RequestMapping(value = "/admin/post/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deletePost(@RequestParam("id") Long id) {
        try {
            Post post = postService.get(id);
            if (post == null) {
                return JsonResult.error("Post doesn't exist");
            }
            if (!loginUserIsAdmin() && !Objects.equals(post.getUserId(), getLoginUserId())) {
                return JsonResult.error("No permission to delete, this is not your post");
            }
            postService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to delete");
        }
        return JsonResult.success("Delete successful");
    }


}
