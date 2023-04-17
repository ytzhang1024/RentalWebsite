package com.yutian.zhang.rental.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yutian.zhang.rental.common.base.BaseService;
import com.yutian.zhang.rental.common.vo.HouseSearchVO;
import com.yutian.zhang.rental.entity.House;

import java.util.List;


/**
 * House service interface
 *
 * @author Yutian Zhang
 * @date 20/12/2021 17:45
 */

public interface HouseService extends BaseService<House, Long> {

    /**
     * Get the latest house ordered by time
     *
     * @param rentType
     * @param limit
     * @return
     */
    List<House> findTopList(String rentType, Integer limit);

    /**
     * Get the pagination of house info
     *
     * @param houseSearchVO
     * @param page
     * @return
     */
    Page<House> getHousePage(HouseSearchVO houseSearchVO, Page<House> page);

    /**
     * Search house by id
     *
     * @param userId
     * @param certificateNo
     * @param rentType
     * @return
     */
    List<House> findByUserIdAndCertificateNoAndRentType(Long userId, String certificateNo, String rentType);


}
