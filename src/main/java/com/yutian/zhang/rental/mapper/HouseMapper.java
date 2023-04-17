package com.yutian.zhang.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.vo.HouseSearchVO;
import com.yutian.zhang.rental.entity.House;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * House Mapper
 *
 * @author Yutian Zhang
 * @date 20/12/2021 16:05
 */
@Mapper
public interface HouseMapper extends BaseMapper<House> {

    @Select("select * from t_house where status = 1 and rent_type = #{rentType} order by create_time desc limit #{limit}")
    List<House> findTopList(@Param("rentType") String rentType,
                            @Param("limit") Integer limit);

    List<House> searchHouse(@Param("houseSearchVO") HouseSearchVO houseSearchVO,
                            @Param("page") Page page);


}
