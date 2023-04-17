package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * Order entity
 *
 * @author Yutian Zhang
 * @date 27/01/2022 14:53
 */
@Data
@TableName("t_order")
public class Order extends BaseEntity {

    /**
     * Order status: -2 pending contract, -1 pending payment, 0 in force, 1 expired, -3 cancelled, 2 request for refund, 3 request for refund not approved
     */
    private Integer status;

    /**
     * tenant id
     */
    private Long customerUserId;

    /**
     * landlord id
     */
    private Long ownerUserId;

    /**
     * house ID
     */
    private Long houseId;

    /**
     * Monthly Rent
     */
    private Integer monthRent;

    /**
     * rental days
     */
    private Integer dayNum;

    /**
     * total amount
     */
    private Integer totalAmount;

    /**
     * rental start date
     */
    private Date startDate;

    /**
     * rental end date
     */
    private Date endDate;

    /**
     * house info
     */
    @TableField(exist = false)
    private House house;


    /**
     * tenant info
     */
    @TableField(exist = false)
    private User customerUser;


    /**
     * landlord info
     */
    @TableField(exist = false)
    private User ownerUser;
}
