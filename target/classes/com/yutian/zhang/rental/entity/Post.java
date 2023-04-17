package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;

/**
 * User Forum Post
 *
 * @author Yutian Zhang
 * @date 26/01/2022 16:57
 */
@Data
@TableName("t_post")
public class Post extends BaseEntity {

    /**
     * Title
     */
    private String title;

    /**
     * Content
     */
    private String content;

    /**
     * Summary
     */
    private String summary;

    /**
     * User Id
     */
    private Long userId;

    /**
     * Post type
     */
    private String postType;

    /**
     * User
     */
    @TableField(exist = false)
    private User user;
}
