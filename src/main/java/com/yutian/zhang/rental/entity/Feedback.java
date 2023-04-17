package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;

/**
 * Feedback entity
 *
 * @author Yutian Zhang
 * @date 28/1/2022 12:06
 */
@Data
@TableName("t_feedback")
public class Feedback extends BaseEntity {

    /**
     * title
     */
    private String title;

    /**
     * content
     */
    private String content;
    
    /**
     * reply
     */
    private String reply;

    /**
     * feedback user id
     */
    private Long userId;

    /**
     * contact name
     */
    private String contactName;

    /**
     * contact email
     */
    private String contactEmail;

    /**
     * Status: 0 pending, 1 done
     */
    private Integer status;


}

