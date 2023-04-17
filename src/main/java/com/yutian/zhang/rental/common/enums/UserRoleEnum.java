package com.yutian.zhang.rental.common.enums;

/**
 * User roles
 * @author Yutian Zhang
 * @date 18/12/2021 20:53
 */

public enum UserRoleEnum {
    /**
     * Administrator
     */
    ADMIN("admin"),

    /**
     * Landlord
     */
    OWNER("owner"),

    /**
     * Tenant
     */
    CUSTOMER("customer"),

    ;

    private String value;

    UserRoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
