package com.yutian.zhang.rental.common.dto;

import lombok.Data;

/**
 * <pre>
 *     Json format
 * </pre>
 *
 * @author : czarhao
 * @date : 2019/5/24
 */
@Data
public class JsonResult {

    /**
     * Status code returned, 0: failure, 1: success
     */
    private Integer code;

    /**
     * Messages return
     */
    private String msg;

    /**
     * Date return
     */
    private Object result;

    /**
     * Constructors that do not return data
     *
     * @param code
     * @param msg
     */
    public JsonResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Constructor for returning data
     *
     * @param code
     * @param msg
     * @param result
     */
    public JsonResult(Integer code, String msg, Object result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    /**
     * Return status codes and data
     *
     * @param code
     * @param result
     */
    public JsonResult(Integer code, Object result) {
        this.code = code;
        this.result = result;
    }

    public static JsonResult error(String msg) {
        return new JsonResult(500, msg);
    }

    public static JsonResult error(String msg, Object data) {
        return new JsonResult(500, msg, data);
    }

    public static JsonResult success() {
        return new JsonResult(200, "Operation successful");
    }

    public static JsonResult success(String msg) {
        return new JsonResult(200, msg);
    }

    public static JsonResult success(String msg, Object result) {
        return new JsonResult(200, msg, result);
    }

}
