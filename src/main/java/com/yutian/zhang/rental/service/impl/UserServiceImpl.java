package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.mapper.*;
import com.yutian.zhang.rental.service.UserService;
import com.yutian.zhang.rental.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yutian Zhang
 * @date 05/01/2022 14:44
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private MarkMapper markMapper;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public BaseMapper<User> getRepository() {
        return userMapper;
    }

    @Override
    public QueryWrapper<User> getQueryWrapper(User user) {
        return null;
    }

    @Override
    public QueryWrapper<User> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_name", userName);
        return userMapper.selectOne(queryWrapper);
    }


    public User findByUserId(Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        return userMapper.selectOne(queryWrapper);
    }

    public User getLandlordByHouseId(Long id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", id);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        userMapper.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", id);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("post_user_id", id);
        orderMapper.deleteByMap(map);
        commentMapper.deleteByMap(map);
        commentMapper.deleteByMap(map2);
        markMapper.deleteByMap(map);
        feedbackMapper.deleteByMap(map);
        houseMapper.deleteByMap(map);
    }
}
