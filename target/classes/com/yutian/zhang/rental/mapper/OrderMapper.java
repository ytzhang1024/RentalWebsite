package com.yutian.zhang.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Order Mapper
 *
 * @author Yutian Zhang
 * @date 27/01/2022 16:42
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * Check for orders due
     *
     * @return
     */
    @Select("select * from t_order where status = 0 and  end_date < now()")
    List<Order> findOverDueOrderList();
}
