package com.yutian.zhang.rental.common.enums;

/**
 * Post
 * @author Yutian Zhang
 */

public enum PostTypeEnum {
    /**
     * Seeking to rent
     */
    SEEK_FOR_RENT("seek_for_rent"),

    ;

    private String value;

    PostTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
