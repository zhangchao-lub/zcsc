package com.dachaoge.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/23 16:27
 * @descrption
 */
@RestController
@RequestMapping("demo")
@Slf4j
public class MainController2 {

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("client4")
    public Object client4() {

        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance choose = lb.choose("sc-eureka-provider");
        String url = null;
        String respStr = null;

        url = choose.getUri() + "/getHi";
        log.info("url:" + url);
        respStr = restTemplate.getForObject(url, String.class);
        log.info("restTemplate调用:" + respStr);

        return respStr;
    }

    /**
     * 手动负载均衡
     *
     * @return
     */
    @Autowired
    DiscoveryClient client;

    @GetMapping("client5")
    public Object client5() {

        // 获取服务列表
        List<ServiceInstance> instances = client.getInstances("sc-eureka-provider");
        log.info("instances:" + instances);
        String url = null;
        String respStr = null;
        if (instances.size() > 0) {
            //自定义轮询算法

            //获取随机数
            int nextInt = new Random().nextInt(instances.size());
            AtomicInteger atomicInteger = new AtomicInteger();

            //轮询
            int andIncrement = atomicInteger.getAndIncrement();
            instances.get(andIncrement % instances.size());

            //权重
            for (ServiceInstance serviceInstance : instances) {
                serviceInstance.getMetadata();//权重1-9
            }
            ServiceInstance instance = instances.get(nextInt);
            url = instance.getUri() + "/getHi";
            log.info("url:" + url);
            respStr = restTemplate.getForObject(url, String.class);
            log.info("restTemplate调用:" + respStr);
        }
        return respStr;
    }

    @GetMapping("client6")
    public Object client6() {

        //自动处理Url sc-eureka-provider被解析成路径
        String url="http://sc-eureka-provider/getHi";
        String respStr=restTemplate.getForObject(url, String.class);
//        return respStr;
        return "First redeploy prevented! You're on the right track! Keep on! "+respStr;

    }

}


