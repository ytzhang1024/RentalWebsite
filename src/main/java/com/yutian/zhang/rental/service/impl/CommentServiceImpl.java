package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.Comment;
import com.yutian.zhang.rental.mapper.CommentMapper;
import com.yutian.zhang.rental.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Yutian Zhang
 * @date 28/1/2022 20:31
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public BaseMapper<Comment> getRepository() {
        return commentMapper;
    }

    @Override
    public QueryWrapper<Comment> getQueryWrapper(Comment comment) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(comment.getUserId() != null) {
            queryWrapper.eq("user_id", comment.getUserId());
        }

        return queryWrapper;
    }

    @Override
    public QueryWrapper<Comment> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }

}
