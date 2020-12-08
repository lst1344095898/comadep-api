package com.lst.comadep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.lst.comadep.Filter")
public class ComadepApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComadepApplication.class, args);
    }

}
