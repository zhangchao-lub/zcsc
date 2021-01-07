package com.dachaoge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/23 16:08
 * @descrption
 */

@SpringBootApplication
public class ScEurekaConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScEurekaConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
//    @Bean
//    public IRule myRule(){
//        /** 声明ribbon的选择策略*/
//        //区域轮询策略
////        return new RoundRobinRule();
//        //重复策略
//        return new RetryRule();
//        //随机策略
////        return new RandomRule();
//    }
}
