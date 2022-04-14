package com.guigu.srb.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    //由于有2个功能模块，如果把测试类全放在一个模块里太乱了，写2个方法，分为2组
    @Bean
    public Docket AdminApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin")
                .apiInfo(adminInfo())

                ;
    }

    public ApiInfo adminInfo(){
        return new ApiInfoBuilder()
                .title("尚融宝标题")
                .description("描述信息")
                .version("1.1版本")
                .contact(new Contact("姓名","网站","邮箱"))
                .build();
    }

}
