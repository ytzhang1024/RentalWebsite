package com.yutian.zhang.rental.common.enums;

/**
 * Feedback status 0 pending, 1 processed
 *
 * @author Yutian Zhang
 * @date 23/1/2022 14:34
 */

public enum FeedbackStatusEnum {

    NOT_HANDLE(0),
    HAS_HANDLE(1),
    ;

    private Integer value;

    FeedbackStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}