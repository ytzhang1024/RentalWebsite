package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;

/**
 * Comment entities
 *
 * @author Yutian Zhang
 * @date 27/1/2022 10:27
 */
@Data
@TableName("t_comment")
public class Comment extends BaseEntity {

    /**
     * Reply Content
     */
    private String content;

    /**
     * User ID
     */
    private Long userId;

    /**
     * father content user
     */
    private Long postUserId;

    /**
     * father content id
     */
    private Long postId;

    @TableField(exist = false) // This field is not exist in the database
    private Post post;

    @TableField(exist = false)
    private User user;
}
