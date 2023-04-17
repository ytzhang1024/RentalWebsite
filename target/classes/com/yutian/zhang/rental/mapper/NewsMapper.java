package com.yutian.zhang.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.News;
import org.apache.ibatis.annotations.Mapper;

/**
 * News DAO mapper
 *
 * @author Yutian Zhang
 * @date 20/1/2022 17:57
 */
@Mapper
public interface NewsMapper extends BaseMapper<News> {
}
