package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * House Entity
 *
 * @author Yutian Zhang
 * @date 20/12/2021 16:05
 */
@Data
@TableName("t_house")
public class House extends BaseEntity {

    /**
     * User id
     */
    private Long userId;

    /**
     * Whole rent / shared rent
     */
    private String rentType;

    /**
     * House title
     */
    private String title;


    /**
     * Description
     */
    private String content;

    /**
     * City
     */
    private String city;

    /**
     * Address
     */
    private String address;

    /**
     * Thumbnail URL
     */
    private String thumbnailUrl;

    /**
     * Slide URL
     */
    private String slideUrl;

    /**
     * Monthly Rent
     */
    private Integer monthRent;

    /**
     * Status: 0 not rented, 1 rented, -1 removed, -2 pending review, -3 review denied
     */
    private Integer status;

    /**
     * 房产证编号
     */
    private String certificateNo;

    /**
     * Toilet number
     */
    private Integer toiletNum;

    /**
     * kitchen number
     */
    private Integer kitchenNum;

    /**
     * Living room number
     */
    private Integer livingRoomNum;

    /**
     * Bedroom number
     */
    private Integer bedroomNum;

    /**
     * AirConditioner 1 yes 0 no
     */
    private Integer hasAirConditioner;

    /**
     * Area
     */
    private Double area;

    /**
     * Which floor
     */
    private Integer floor;

    /**
     * Highest Floor
     */
    private Integer maxFloor;

    /**
     * Elevator 1 yes 0 no
     */
    private Integer hasElevator;

    /**
     * Which year built
     */
    private Integer buildYear;

    /**
     * direction
     */
    private String direction;

    /**
     * Rental start time
     */
    private Date lastOrderStartTime;

    /**
     * Rental end time
     */
    private Date lastOrderEndTime;

    /**
     * Longitude and latitude
     */
    private String longitudeLatitude;

    /**
     * Contact name
     */
    private String contactName;

    /**
     * Contact phone
     */
    private String contactPhone;

    /**
     * Landlord
     */
    @TableField(exist = false)
    private User ownerUser;

    /**
     * Carousel list
     */
    @TableField(exist = false)
    private List<String> slideImgList;

    /**
     * Current order
     */
    @TableField(exist = false)
    private Order currentOrder;

    /**
     * Shared rent house
     */
    @TableField(exist = false)
    private List<House> shareHouseList;

}
