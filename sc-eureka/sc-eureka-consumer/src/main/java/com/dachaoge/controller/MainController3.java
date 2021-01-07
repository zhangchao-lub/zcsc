package com.dachaoge.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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
public class MainController3 {

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("client7")
    public Object client7() {

        //自动处理Url sc-eureka-provider被解析成路径
        String url = "http://sc-eureka-provider/getHi";
        String respStr = restTemplate.getForObject(url, String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        log.info(forEntity.toString());
        return "First redeploy prevented! You're on the right track! Keep on! " + forEntity;

    }

    @GetMapping("client8")
    public Object client8() {

        //自动处理Url sc-eureka-provider被解析成路径
        String url = "http://sc-eureka-provider/getMap";
        Map forObject = restTemplate.getForObject(url, Map.class);
        log.info(forObject.toString());
        return "First redeploy prevented! You're on the right track! Keep on! " + forObject;

    }

    @GetMapping("client9")
    public Object client9() {

        //自动处理Url sc-eureka-provider被解析成路径
        String url = "http://sc-eureka-provider/getObj";
        Person person = restTemplate.getForObject(url, Person.class);
        log.info(person.toString());
        return person;

    }

    @GetMapping("client10")
    public Object client10() {

        //自动处理Url sc-eureka-provider被解析成路径
        String url = "http://sc-eureka-provider/getObj2?name={1}";
        Person person = restTemplate.getForObject(url, Person.class, "马小六");
        log.info(person.toString());
        return person;

    }

    @GetMapping("client11")
    public Object client11() {

        //自动处理Url sc-eureka-provider被解析成路径
        String url = "http://sc-eureka-provider/getObj2?name={name}";
        Map<String, String> map = Collections.singletonMap("name", "马小静");
        Person person = restTemplate.getForObject(url, Person.class, map);
        log.info(person.toString());
        return person;
    }

    @GetMapping("client12")
    public Object client12() {

        //自动处理Url sc-eureka-provider被解析成路径
        String url = "http://sc-eureka-provider/postObj";
        Map<String, String> map = Collections.singletonMap("name","马小壮dfawefwe");
        Person person = restTemplate.postForObject(url,map,Person.class);
        log.info(person.toString());
        return person;
    }

    @GetMapping("client13")
    public Object client13(HttpServletResponse response) throws IOException {

        //自动处理Url sc-eureka-provider被解析成路径
        String url = "http://sc-eureka-provider/postLocation";
        Map<String, String> map = Collections.singletonMap("name","李白无双");
        URI location = restTemplate.postForLocation(url, map, Person.class);
        log.info(location.toString());

        response.sendRedirect(location.toURL().toString());
        return location;
    }
}


