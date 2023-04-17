package com.yutian.zhang.rental.common.enums;

/**
 * User status
 * @author @author Yutian Zhang
 * @date 05/01/2021 13:21
 */

public enum UserStatusEnum {

    /**
     * Enable
     */
    ENABLE(0),

    /**
     * Disable
     */
    DISABLE(1),

    ;

    private Integer value;

    UserStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
