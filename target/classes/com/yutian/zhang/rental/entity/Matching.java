package com.yutian.zhang.rental.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Matching entity
 * @author Yutian Zhang
 * @date 02/2/2022 10:30
 */
@Data
@TableName("t_matching")
public class Matching {

    private Long Id;

    private int personality;

    private int religion;

    private int ethnicity;

    private int smoking;

    private int drinking;

    private int cooking;

    private int outdoor;

    private int gym;

    private int pets;

    private int sleepingstatus;

    private int games;

    private int photography;

    private int minddiffgender;
}
