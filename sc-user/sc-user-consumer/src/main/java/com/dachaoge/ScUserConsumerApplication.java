package com.dachaoge;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/7 16:07
 * @descrption
 */

@SpringBootApplication
@EnableCircuitBreaker
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
public class ScUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScUserConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }

    /**
     * 高版本springboot 自定义添加 /actuator/hystrix.stream 路径 用与DashBoard可视化工具
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
