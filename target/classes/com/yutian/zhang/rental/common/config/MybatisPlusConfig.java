package com.yutian.zhang.rental.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * MybatisConfig
 * @descrition Configure MVC framework in JavaBean instead of xml configuration file
 * @author Yutian Zhang
 * @date 18/12/2021 23:09
 */
@Configuration
public class MybatisPlusConfig {

    /***
     * Performance optimisation analysis
     * @return
     */
    /** Use when you are in developing mode, not recommend to use in real mode
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(1000);
        performanceInterceptor.setFormat(false);
        return performanceInterceptor;
    }
    **/

    /**
     * Pagination
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    public static String encryp ="gQaR6u0LmEvypN0q6gfuAQ==";


}
