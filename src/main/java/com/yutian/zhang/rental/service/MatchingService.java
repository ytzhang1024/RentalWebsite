package com.yutian.zhang.rental.service;

import com.yutian.zhang.rental.common.base.BaseService;
import com.yutian.zhang.rental.entity.Matching;
import com.yutian.zhang.rental.entity.User;

import java.util.List;

/**
 * MatchingService
 * @descrition Dealing with matching service
 * @author Yutian Zhang
 * @date 02/2/2022 11:13
 */
public interface MatchingService extends BaseService<Matching, Long> {
    /**
     * Find a specific user's interests attributes
     *
     * @param userID
     * @return Matching
     */
    Matching findMatchingAttributes(Long userID);

    /**
     * Get a specific user's matching list
     *
     * @param userID
     * @return
     */
    List<User> matchingList(Long userID);

    boolean checkUserExist(Long userID);

    List<User> findUserAttributes(Long[] orderList);

    List<Matching> findAllUserMatchingAttributes();

    void createUserMatching(Long userID);
}
