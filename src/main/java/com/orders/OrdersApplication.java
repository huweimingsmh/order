package com.orders;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan({"com.orders.mapper"})
public class OrdersApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }



protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
    return builder.sources(OrdersApplication.class);
}
}


