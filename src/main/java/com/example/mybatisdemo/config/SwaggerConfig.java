package com.example.mybatisdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: mybatisdemo
 * @description:
 * @author: WangJJ
 * @create: 2020-09-07 16:42
 **/

@Configuration
@EnableSwagger2  //开启Swagger的自动配置
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.example.mybatisdemo.controller")) // 根据个人项目配置扫描Controller包
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        //Swagger页面上的个人定制配置
        return new ApiInfoBuilder().title("Swagger2-UI")
                .description("mybatis-plus项目Api文档服务")
                .termsOfServiceUrl("http://swagger.io/")
                .contact(new Contact("jian", "https://github.com/jianjie-wang/mybatisdemo", "398971654@qq.com"))
                .version("1.0")
                .build();
    }
}
