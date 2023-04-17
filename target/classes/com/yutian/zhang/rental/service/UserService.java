package com.yutian.zhang.rental.service;

import com.yutian.zhang.rental.common.base.BaseService;
import com.yutian.zhang.rental.entity.User;

/**
 * User Service Interface
 *
 * @author Yutian Zhang
 * @date 05/1/2022 14:42
 */

public interface UserService extends BaseService<User, Long> {

    /**
     * Search users by their names
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);

    User getLandlordByHouseId(Long id);

    User findByUserId(Long id);
}
