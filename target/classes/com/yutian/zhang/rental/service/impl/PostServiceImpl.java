package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.Post;
import com.yutian.zhang.rental.mapper.CommentMapper;
import com.yutian.zhang.rental.mapper.PostMapper;
import com.yutian.zhang.rental.service.PostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Post Service
 * @author Yutian Zhang
 * @date 26/01/2022 18:21
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public BaseMapper<Post> getRepository() {
        return postMapper;
    }

    @Override
    public QueryWrapper<Post> getQueryWrapper(Post post) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(post.getUserId() != null) {
            queryWrapper.eq("user_id", post.getUserId());
        }
        if(StringUtils.isNotEmpty(post.getPostType())) {
            queryWrapper.eq("post_type", post.getPostType());
        }
        return queryWrapper;
    }

    @Override
    public QueryWrapper<Post> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        postMapper.deleteById(id);

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", id);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("post_user_id", id);

        commentMapper.deleteByMap(map);
        commentMapper.deleteByMap(map2);
    }
}
