package com.yutian.zhang.rental.common.enums;
/**
 * House Status
 *
 * @author Yutian Zhang
 * @date 18/12/2022 15:28
 */
public enum HouseStatusEnum {
    /**
     * Displaying
     */
    NOT_RENT(1),

    /**
     * Leased out
     */
    HAS_RENT(0),

    /**
     * Removed
     */
    HAS_DOWN(-1),

    /**
     * Pending check
     */
    NOT_CHECK(-2),
    /**
     * Check reject
     */
    CHECK_REJECT(-3);

    private Integer value;

    HouseStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
