package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@SpringBootApplication
//@ServletComponentScan
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@SpringBootApplication(scanBasePackages = { "com.example.demo1"})
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)  // 启动权限拦截注解
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
