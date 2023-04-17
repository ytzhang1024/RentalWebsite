package com.yutian.zhang.rental.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.Comment;
import com.yutian.zhang.rental.entity.Post;
import com.yutian.zhang.rental.service.CommentService;
import com.yutian.zhang.rental.service.PostService;
import com.yutian.zhang.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Post Controller
 *
 * @author Yutian Zhang
 * @date 26/01/2022 20:45
 */
@Controller
public class PostController extends BaseController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    /**
     * Posted list
     *
     * @param pageNumber
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/post")
    public String index(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                        @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                        Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Page<Post> postPage = postService.findAll(page);
        model.addAttribute("pageInfo", postPage);
        model.addAttribute("pagePrefix", "/post?");
        return "front/post-list";
    }




    /**
     * Post detail
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/post/detail/{id}")
    public String postDetail(@PathVariable("id") Long id, Model model) {
        Post post = postService.get(id);
        if (post == null) {
            return this.renderNotFound();
        }
        post.setUser(userService.get(post.getUserId()));
        model.addAttribute("post", post);

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("post_id", id);
        List<Comment> commentList =  commentService.findAll(queryWrapper);
        for(Comment comment :commentList) {
            comment.setUser(userService.get(comment.getUserId()));
        }
        model.addAttribute("commentList", commentList);
        return "front/post-detail";
    }
}
