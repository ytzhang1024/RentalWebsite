package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.Matching;
import com.yutian.zhang.rental.entity.User;
import com.yutian.zhang.rental.mapper.MatchingMapper;
import com.yutian.zhang.rental.mapper.UserMapper;
import com.yutian.zhang.rental.service.MatchingService;
import com.yutian.zhang.rental.common.matchalgorithm.MatchingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MatchingService
 * @descrition Dealing with matching service
 * @author Yutian Zhang
 * @date 02/2/2022 11:14
 */
@Service
public class MatchingServiceImpl implements MatchingService {

    @Autowired
    private MatchingMapper matchingMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<Matching> getRepository() {
        return matchingMapper;
    }

    @Override
    public QueryWrapper<Matching> getQueryWrapper(Matching matching) {
        return null;
    }

    @Override
    public QueryWrapper<Matching> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }

    //for back-stage use
    public Matching findMatchingAttributes(Long userID){
        return matchingMapper.findMatchingAttributes(userID);
    }

    public List<User> matchingList(Long userID){
        List<Matching> ls = findAllUserMatchingAttributes(); //get all user's attributes
        Long[] orderList = MatchingAlgorithm.matchingAlgorithm(ls, userID);//get the similarity of users
        List<User> userList = findUserAttributes(orderList);
        return userList;
    }

    public List<Matching> findAllUserMatchingAttributes(){
        return matchingMapper.findAllUserMatchingAttributes();
    }


    public boolean checkUserExist(Long userID){
        int num = matchingMapper.checkIfUserExist(userID);
        if ( num > 0 ) {
            return true;
        }
        return false;
    }

    public void createUserMatching(Long userID){
        matchingMapper.createNewMatching(userID);
    }

    public List<User> findUserAttributes(Long[] userOrderList){
        List<User> userList = new ArrayList<>(); // must be initialized otherwise appearing no pointer exception.
        for (int i = 0; i < userOrderList.length - 1; i++) {
            User user = userMapper.findByUserId(userOrderList[i]);
            if(user != null){
                userList.add(user);
            }
        }
        return userList;
    }

}
