package com.yutian.zhang.rental.service;

import com.yutian.zhang.rental.common.base.BaseService;
import com.yutian.zhang.rental.entity.Mark;

import java.util.List;

/**
 * Mark Interface
 *
 * @author Yutian Zhang
 * @date 15/1/2022 20:07
 */

public interface MarkService extends BaseService<Mark, Long> {

    /**
     *
     * @param userId
     * @param houseId
     * @return
     */
    List<Mark> findByUserIdAndHouseId(Long userId, Long houseId);
}
