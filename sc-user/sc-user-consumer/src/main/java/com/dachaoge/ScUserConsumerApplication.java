package com.dachaoge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/7 16:07
 * @descrption
 */

@SpringBootApplication
@EnableFeignClients
public class ScUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScUserConsumerApplication.class, args);
    }
}
