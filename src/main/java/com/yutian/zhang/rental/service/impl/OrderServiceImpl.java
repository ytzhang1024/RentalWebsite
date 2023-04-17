package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.common.enums.OrderStatusEnum;
import com.yutian.zhang.rental.entity.Order;
import com.yutian.zhang.rental.mapper.OrderMapper;
import com.yutian.zhang.rental.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Order Service
 * @author Yutian Zhang
 * @date 27/01/2022 17:13
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public BaseMapper<Order> getRepository() {
        return orderMapper;
    }

    @Override
    public QueryWrapper<Order> getQueryWrapper(Order order) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper();
        if (order != null) {
            if (order.getOwnerUserId() != null) {
                queryWrapper.eq("owner_user_id", order.getOwnerUserId());
            }
            if (order.getCustomerUserId() != null) {
                queryWrapper.eq("customer_user_id", order.getCustomerUserId());
            }
            if (order.getStatus() != null) {
                queryWrapper.eq("status", order.getStatus());
            }
        }
        return queryWrapper;
    }

    @Override
    public QueryWrapper<Order> getQueryWrapper(Map<String, Object> condition) {
        return null;
    }

    @Override
    public Order getCurrentEffectiveOrder(Long houseId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("house_id", houseId);
        queryWrapper.eq("status", OrderStatusEnum.NORMAL.getValue());
        return orderMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Order> findOverDueOrderList() {
        return orderMapper.findOverDueOrderList();
    }
}
