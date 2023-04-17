package com.yutian.zhang.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

/**
 * Feedback DAO Mapper
 *
 * @author Yutian Zhang
 * @date 28/1/2022 11:54
 */
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {
}
