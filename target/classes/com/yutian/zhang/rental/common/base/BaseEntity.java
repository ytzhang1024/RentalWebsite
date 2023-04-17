package com.yutian.zhang.rental.common.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * BaseEntity
 * @descrition Provide basic entities
 * @author Yutian Zhang
 * @date 17/12/2021 12:35
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * Automatic id generation function
     */
    @TableId(type = IdType.AUTO)
    private Long id;


    /**
     * Create time
     */
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+0")
    private Date createTime;

}
