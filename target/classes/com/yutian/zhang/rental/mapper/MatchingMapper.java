package com.yutian.zhang.rental.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yutian.zhang.rental.entity.Matching;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Matching DAO Mapper
 *
 * @author Yutian Zhang
 * @date 27/1/2022 11:54
 */
@Mapper
public interface MatchingMapper extends BaseMapper<Matching> {

    @Select("select * from t_matching where id = #{UserID}")
    Matching findMatchingAttributes(@Param("UserID") Long UserID);

    @Select("select * from t_matching")
    List<Matching> findAllUserMatchingAttributes();

    @Select("select count(1) from t_matching where id = #{UserID}")
    int checkIfUserExist(@Param("UserID") Long UserID);

    @Insert("insert into t_matching (id, personality, religion, ethnicity, smoking, drinking, cooking, outdoor, gym, pets, sleepingstatus, games, photography, minddiffgender) values (#{UserID}, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);")
    void createNewMatching(@Param("UserID") Long UserID);
}
