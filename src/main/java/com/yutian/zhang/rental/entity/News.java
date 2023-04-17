package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.yutian.zhang.rental.common.base.BaseEntity;
import lombok.Data;

/**
 * Newsletter
 *
 * @author Yutian Zhang
 * @date 20/1/2022 17:55
 */
@Data
@TableName("t_news")
public class News extends BaseEntity {

    /**
     * title
     */
    private String title;

    /**
     * content
     */
    private String content;

    /**
     * summary
     */
    private String summary;
}
