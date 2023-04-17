package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.Feedback;
import com.yutian.zhang.rental.mapper.FeedbackMapper;
import com.yutian.zhang.rental.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Yutian Zhang
 * @date 28/1/2022 20:31
 */

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public BaseMapper<Feedback> getRepository() {
        return feedbackMapper;
    }

    @Override
    public QueryWrapper<Feedback> getQueryWrapper(Feedback feedback) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (feedback != null) {
            if (feedback.getUserId() != null) {
                queryWrapper.eq("user_id", feedback.getUserId());
            }
        }
        return queryWrapper;
    }

    @Override
    public QueryWrapper<Feedback> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }
}
