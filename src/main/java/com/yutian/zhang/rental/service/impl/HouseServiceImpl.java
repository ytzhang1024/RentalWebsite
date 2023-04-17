package com.yutian.zhang.rental.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.vo.HouseSearchVO;
import com.yutian.zhang.rental.entity.House;
import com.yutian.zhang.rental.mapper.HouseMapper;
import com.yutian.zhang.rental.service.HouseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Yutian Zhang
 * @date 20/12/2021 17:47
 */

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public BaseMapper<House> getRepository() {
        return houseMapper;
    }

    @Override
    public QueryWrapper<House> getQueryWrapper(House house) {
        QueryWrapper<House> queryWrapper = new QueryWrapper();
        if (house != null) {
            if (house.getUserId() != null) {
                queryWrapper.eq("user_id", house.getUserId());
            }
        }
        return queryWrapper;
    }

    @Override
    public QueryWrapper<House> getQueryWrapper(Map<String, Object> condition) {
        QueryWrapper<House> queryWrapper = new QueryWrapper();
        return queryWrapper;
    }

    @Override
    public List<House> findTopList(String rentType, Integer limit) {
        return houseMapper.findTopList(rentType, limit);
    }

    @Override
    public Page<House> getHousePage(HouseSearchVO houseSearchVO, Page<House> page) {
        if (houseSearchVO != null) {
            String areaRange = houseSearchVO.getAreaRange();
            String priceRange = houseSearchVO.getPriceRange();

            Integer minArea = 0;
            Integer maxArea = 300;
            if (StringUtils.isNotEmpty(areaRange)) {
                String[] arr = areaRange.split(";");
                if (arr.length == 2) {
                    minArea = Integer.valueOf(arr[0]);
                    maxArea = Integer.valueOf(arr[1]);
                }
            }

            Integer minPrice = 0;
            Integer maxPrice = 20000;
            if (StringUtils.isNotEmpty(priceRange)) {
                String[] arr = priceRange.split(";");
                if (arr.length == 2) {
                    minPrice = Integer.valueOf(arr[0]);
                    maxPrice = Integer.valueOf(arr[1]);
                }
            }
            houseSearchVO.setMinArea(minArea);
            houseSearchVO.setMaxArea(maxArea);
            houseSearchVO.setMinPrice(minPrice);
            houseSearchVO.setMaxPrice(maxPrice);
        } else {
            houseSearchVO = new HouseSearchVO();
        }


        List<House> houseList = houseMapper.searchHouse(houseSearchVO, page);
        return page.setRecords(houseList);
    }

    @Override
    public List<House> findByUserIdAndCertificateNoAndRentType(Long userId, String certificateNo, String rentType) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("certificate_no", certificateNo);
        queryWrapper.eq("rent_type", rentType);
        queryWrapper.orderByAsc("title");

        // select * from t_house where
        // user_id = #{userId} AND certificate_no = #{certificateNo} and = rent_type = #{rent_type}
        // order by title ASC
        return houseMapper.selectList(queryWrapper);
    }
}
