package com.yutian.zhang.rental.common.enums;

/**
 * Order Status
 *
 * @author Yutian Zhang
 * @date 27/12/2022 21:05
 */

public enum OrderStatusEnum {

    /**
     * Contracts to be signed
     */
    NOT_AGREEMENT(-2),

    /**
     * Payment pending
     */
    NOT_PAY(-1),


    /**
     * In force
     */
    NORMAL(0),

    /**
     * Surrender of rent
     */
    FINISH(1),

    /**
     * Tenant cancelled
     */
    CUSTOMER_CANCEL(-3),


    /**
     * Application for Rent Refund
     */
    END_APPLY(2),

    /**
     * Application for rent refund not approved
     */
    END_APPLY_REJECT(3),


    ;

    private Integer value;

    OrderStatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}