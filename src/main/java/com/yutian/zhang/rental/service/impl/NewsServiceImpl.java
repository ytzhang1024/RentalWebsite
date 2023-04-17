package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.News;
import com.yutian.zhang.rental.mapper.NewsMapper;
import com.yutian.zhang.rental.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Newsletter Service
 * @author Yutian Zhang
 * @date 20/1/2022 17:58
 */

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public BaseMapper<News> getRepository() {
        return newsMapper;
    }

    @Override
    public QueryWrapper<News> getQueryWrapper(News news) {

        QueryWrapper<News> queryWrapper = new QueryWrapper<>();

        return queryWrapper;
    }

    @Override
    public QueryWrapper<News> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }
}
