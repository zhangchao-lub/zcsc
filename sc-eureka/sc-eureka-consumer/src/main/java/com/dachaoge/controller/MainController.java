package com.dachaoge.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/23 16:27
 * @descrption
 */
@RestController
@RequestMapping("demo")
@Slf4j
public class MainController {

    @Autowired
    DiscoveryClient client;
    @Resource
    EurekaClient client2;
    @Autowired
    LoadBalancerClient lb;

    @GetMapping("client")
    public String client() {
        List<String> services = client.getServices();
        return services.toString();
    }

    @GetMapping("client2")
    public Object client2() {
        //具体服务
//        List<InstanceInfo> instances = client2.getInstancesById("172.16.2.166:sc-eureka-provider:710");

        //使用服务名 找列表
        List<InstanceInfo> instances = client2.getInstancesByVipAddress("sc-eureka-provider", false);
        for (InstanceInfo ins : instances) {
            log.info(ToStringBuilder.reflectionToString(ins));
        }
        String url = null;
        String respStr = null;
        if (instances.size() > 0) {
            InstanceInfo instanceInfo = instances.get(0);
            if (instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP) {
                url = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/getHi";
                log.info("url:" + url);
                RestTemplate restTemplate = new RestTemplate();
                respStr = restTemplate.getForObject(url, String.class);
                log.info("纯手工调用:" + respStr);
            }
        }
        return respStr;
    }

    @GetMapping("client3")
    public Object client3() {

        // ribbon 完成客户端的负载均衡，过滤掉down了的节点
        ServiceInstance choose = lb.choose("sc-eureka-provider");
        String url = null;
        String respStr = null;

        url = choose.getUri() + "/getHi";
        log.info("url:" + url);
        RestTemplate restTemplate = new RestTemplate();
        respStr = restTemplate.getForObject(url, String.class);
        log.info("纯手工调用:" + respStr);

        return respStr;
    }
}


