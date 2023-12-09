package com.moz.ates.traffic.police;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.moz.ates.traffic.police","com.moz.ates.traffic.common"})
public class PoliceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoliceApplication.class, args);
    }

}
