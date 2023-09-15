package com.wanmait.exam.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.wanmait.exam.inerceptor.JWTInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@MapperScan("com.wanmait.exam.mapper")
public class MybatisConfig implements WebMvcConfigurer {

    @Resource
    private JWTInterceptor jwtInterceptor;
    //mybatis-plus的分页插件
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        //registry.addResourceHandler("/abc/**").addResourceLocations("file:D:/static/");
    }

    //统一配置跨域资源共享
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许哪些源可以通过ajax跨域请求当前的项目
                //.allowedOrigins("https://www.wanmait.com","https://www.qingruanit.net")
                .allowedOrigins("*")
                //允许哪些请求方式
                //.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedMethods("*")
                //允许哪些请求头
                .allowedHeaders("*")
                //.allowCredentials(true) 如果设为true 可以传送cookie信息，session也就能用，客户端要配合设置xhr.withCredentials=true
                //预检请求缓存时间
                .maxAge(60*60*2);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/manage/**").excludePathPatterns("/manage/login");
    }
}
