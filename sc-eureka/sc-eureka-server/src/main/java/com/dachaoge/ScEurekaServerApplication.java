package com.dachaoge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/23 11:04
 * @descrption
 */
@EnableEurekaServer
@SpringBootApplication
public class ScEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScEurekaServerApplication.class, args);
    }
}
