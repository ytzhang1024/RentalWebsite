package com.yutian.zhang.rental.common.vo;

import lombok.Data;

/**
 * House search VO
 *
 */
@Data
public class HouseSearchVO {

    /**
     * Page
     */
    private Integer page = 1;

    /**
     * Page size
     */
    private Integer size = 6;

    /**
     * Status
     */
    private Integer status = 1;

    /**
     * Rent type
     */
    private String rentType;
    /**
     * City
     */
    private String city = "";
    /**
     * Address
     */
    private String address = "";
    /**
     * Area range
     */
    private String areaRange = "0;150";
    /**
     * Price range
     */
    private String priceRange = "0;10000";
    /**
     * Minimum area
     */
    private Integer minArea = 0;
    /**
     * Maximum area
     */
    private Integer maxArea = 150;
    /**
     * Minimum price
     */
    private Integer minPrice = 0;
    /**
     * maximum price
     */
    private Integer maxPrice = 10000;


    /**
     * Get attributes for pagination
     *
     * @return
     */
    public String getPagePrefix() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?address=").append(this.address);
        stringBuilder.append("&rentType=").append(this.rentType);
        stringBuilder.append("&priceRange=").append(this.priceRange);
        stringBuilder.append("&areaRange=").append(this.areaRange);
        return stringBuilder.toString();
    }
}
