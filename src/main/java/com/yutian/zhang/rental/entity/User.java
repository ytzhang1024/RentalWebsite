package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;


/**
 * User Entity
 *
 * @author Yutian Zhang
 * @date 05/1/2022 13:08
 */
@Data
@TableName("t_user")
public class User extends BaseEntity {

    /**
     * username
     */
    private String userName;

    /**
     * Display name
     */
    private String userDisplayName;

    /**
     * Password
     */
    private String userPass;

    /**
     * Id number
     */
    private String idCard;

    /**
     * Avatar
     */
    private String userAvatar;

    /**
     * Description
     */
    private String userDesc;

    /**
     * 0 Enable
     * 1 Disable
     */
    private Integer status = 0;

    /**
     * Email
     */
    private String email;

    /**
     * Phone Number
     */
    private String phone;

    /**
     * gender
     */
    private String gender;

    /**
     * Monthly budget
     */
    private String budget;

    /**
     * Nationality
     */
    private String nationality;

    /**
     * City that user want to live in
     */
    private String wantcity;

    /**
     * Role
     */
    private String role;


}
