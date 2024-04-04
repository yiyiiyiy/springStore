package com.zys.springstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//开启对servlet组件的支持
@SpringBootApplication
public class SpringStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStoreApplication.class, args);
    }

}
