package com.yutian.zhang.rental.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.News;
import com.yutian.zhang.rental.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * News Controller
 * @description Handle requests for newsletter
 * @author Yutian Zhang
 * @date 21/1/2022 14:42
 */
@Controller
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    /**
     * Get news list
     *
     * @param pageNumber
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/news")
    public String index(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                        @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                        Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        Page<News> newsPage = newsService.findAll(page);
        model.addAttribute("pageInfo", newsPage);
        model.addAttribute("pagePrefix", "/news?");
        return "front/news-list";
    }




    /**
     * News detail
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/news/detail/{id}")
    public String newsDetail(@PathVariable("id") Long id, Model model) {
        News news = newsService.get(id);
        if (news == null) {
            return this.renderNotFound();
        }
        model.addAttribute("news", news);
        return "front/news-detail";
    }
}
