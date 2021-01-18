package com.dachaoge;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/18 11:28
 * @descrption 健康检测
 */

@SpringBootApplication
@EnableAdminServer
public class ScAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScAdminServerApplication.class, args);
    }
}
