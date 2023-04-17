package com.yutian.zhang.rental.service;

import com.yutian.zhang.rental.common.base.BaseService;
import com.yutian.zhang.rental.entity.Order;

import java.util.List;

/**
 * Order service interface
 *
 * @author Yutian Zhang
 * @date 27/01/2022 17:11
 */

public interface OrderService extends BaseService<Order, Long> {

    /**
     * Check current active orders
     *
     * @param houseId
     * @return
     */
    Order getCurrentEffectiveOrder(Long houseId);

    /**
     * Check for orders that have expired
     * @return
     */
    List<Order> findOverDueOrderList();
}
