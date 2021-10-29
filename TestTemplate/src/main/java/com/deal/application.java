package com.deal;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(application.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
//        ConfigurableApplicationContext run = SpringApplication.run(application.class, args);

    }
}
