package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;

/**
 * Mark
 *
 * @author Yutian Zhang
 * @date 28/1/2022 20:31
 */
@Data
@TableName("t_mark")
public class Mark extends BaseEntity {
    /**
     * UserID
     */
    private Long userId;

    /**
     * HouseID
     */
    private Long houseId;

    /**
     * House Info
     */
    @TableField(exist = false)
    private House house;
}
