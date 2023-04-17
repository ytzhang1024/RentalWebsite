package com.yutian.zhang.rental.controller.backend;

import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseController;
import com.yutian.zhang.rental.common.dto.JsonResult;
import com.yutian.zhang.rental.common.util.PageUtil;
import com.yutian.zhang.rental.entity.News;
import com.yutian.zhang.rental.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * NewsController
 *
 * @author Yutian Zhang
 * @date 20/1/2022 18:05
 */
@Controller("backNewsController")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;


    /**
     * News list
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/news")
    public String allNews(@RequestParam(value = "page", defaultValue = "1") Integer pageNumber,
                          @RequestParam(value = "size", defaultValue = "6") Integer pageSize,
                          Model model) {
        Page page = PageUtil.initMpPage(pageNumber, pageSize);
        News condition = new News();
        Page<News> newsPage = newsService.findAll(page, condition);
        model.addAttribute("pageInfo", newsPage);

        model.addAttribute("tab", "news-list");
        model.addAttribute("pagePrefix", "/admin/news?");
        return "admin/news-list";
    }

    /**
     * Edit and publish news
     *
     * @param model
     * @return
     */
    @RequestMapping("/admin/news/publish")
    public String publish(@RequestParam(value = "id", required = false) Long id, Model model) {
        News news;
        if (id != null) {
            news = newsService.get(id);
            if (news == null) {
                return this.renderNotFound();
            }
        } else {
            news = new News();
        }
        model.addAttribute("news", news);
        return "admin/news-publish";
    }

    /**
     * News submit
     *
     * @return
     */
    @RequestMapping(value = "/admin/news/publish/submit", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult publishSubmit(News news) {
        try {
            int postSummary = 300;
            String summaryText = HtmlUtil.cleanHtmlTag(news.getContent());
            if (summaryText.length() > postSummary) {
                String summary = summaryText.substring(0, postSummary);
                news.setSummary(summary);
            } else {
                news.setSummary(summaryText);
            }
            news.setCreateTime(new Date());
            newsService.insertOrUpdate(news);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Publish Fail");
        }
        return JsonResult.success("Publish successful", news.getId());
    }


    /**
     * Delete news
     *
     * @return
     */
    @RequestMapping(value = "/admin/news/delete", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult deleteNews(@RequestParam("id") Long id) {
        try {
            newsService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.error("Failed to delete news");
        }
        return JsonResult.success("Delete news successful");
    }

}
