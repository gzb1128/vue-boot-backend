package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.webapp.dao")
public class VueBootBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueBootBackendApplication.class, args);
    }

}
