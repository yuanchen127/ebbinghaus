package org.ike.ebbinghaus.config;

import org.ike.ebbinghaus.filter.EncodingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * 这是另一种设置filter的方式，取消@Configuration注释即可生效
 */
//@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registerFilter() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter(getEncodingFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public EncodingFilter getEncodingFilter() {
        return new EncodingFilter();
    }
}
