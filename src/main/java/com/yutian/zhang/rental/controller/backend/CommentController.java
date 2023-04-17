package com.yutian.zhang.rental.controller.backend;

import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.Comment;
import com.yutian.zhang.rental.entity.Post;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.service.CommentService;
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
 * CommentController
 *
 * @author Yutian Zhang
 * @date 27/1/2022 13:35
 */
@Controller("backCommentController")
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    /**
     * Comment Management
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/comment")
    public String allComment(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                             @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                             Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Comment condition = new Comment();
        if (!loginUserIsAdmin()) {
            condition.setUserId(getLoginUserId());
        }
        condition.setUserId(getLoginUserId());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", getLoginUserId());
        queryWrapper.or();
        queryWrapper.eq("post_user_id", getLoginUserId());
        Page<Comment> commentPage = commentService.findAll(page, queryWrapper);
        for (Comment temp : commentPage.getRecords()) {
            temp.setUser(userService.get(temp.getUserId()));
            temp.setPost(postService.get(temp.getPostId()));
        }
        model.addAttribute("pageInfo", commentPage);

        model.addAttribute("tab", "comment-list");
        model.addAttribute("pagePrefix", "/admin/comment?");

        return "admin/comment-list";
    }


    /**
     * Post comment
     *
     * @return
     */
    @RequestMapping(value = "/admin/comment/publish/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult publishSubmit(Comment comment, HttpSession session) {
        User user = getLoginUser();
        if (user == null) {
            return JsonResult.error("User not logged in");
        }

        try {

            if (comment.getId() == null) {
                comment.setCreateTime(new Date());
                comment.setUserId(getLoginUserId());

                Post post = postService.get(comment.getPostId());
                if(post == null) {
                    return JsonResult.error("Post do not exist");
                }

                comment.setPostUserId(post.getUserId());
            }
            comment.setContent(HtmlUtil.cleanHtmlTag(comment.getContent()));
            commentService.insertOrUpdate(comment);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Posting failed, please fill in the full information");
        }
        return JsonResult.success("Posting success", comment.getId());
    }


    /**
     * Delete Comment
     *
     * @return
     */
    @RequestMapping(value = "/admin/comment/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteComment(@RequestParam("id") Long id) {
        try {
            Comment comment = commentService.get(id);
            if (comment == null) {
                return JsonResult.error("Comment does not exist");
            }
            if (!loginUserIsAdmin() && !Objects.equals(comment.getUserId(), getLoginUserId()) && !Objects.equals(comment.getPostUserId(), getLoginUserId())) {
                return JsonResult.error("No permission to delete");
            }
            commentService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Delete comment failed");
        }
        return JsonResult.success("Delete successful");
    }


}
