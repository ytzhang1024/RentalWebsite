package com.yutian.zhang.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * User Mapper
 *
 * @author Yutian Zhang
 * @date 05/1/2022 13:56
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where id = #{id}")
    User findByUserId(@Param("id") Long id);

    @Select("SELECT * FROM t_user, t_house WHERE t_house.id = #{id} AND t_house.user_id = t_user.id")
    User getLandlordByHouseId(@Param("id") Long id);

}
