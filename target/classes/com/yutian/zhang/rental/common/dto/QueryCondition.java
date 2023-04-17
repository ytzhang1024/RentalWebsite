package com.yutian.zhang.rental.common.dto;

import lombok.Data;
import java.io.Serializable;

/**
 *
 * @author mapr-demos
 * @date 2016-03-25 13:45
 */
@Data
public class QueryCondition<T> implements Serializable {

    private T data;


    public QueryCondition() {
    }

    public QueryCondition(T data) {
        this.data = data;
    }

}
