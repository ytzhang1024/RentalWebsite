package com.yutian.zhang.rental.common.enums;

/**
 * Rental type
 *
 * @author Yutian Zhang
 * @date 18/12/2022 14:39
 */

public enum HouseRentTypeEnum {

    WHOLE("whole"),
    SHARE("share"),
    ;

    private String value;

    HouseRentTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
