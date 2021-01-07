package com.dachaoge.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/12/23 16:27
 * @descrption
 */
@Slf4j
@RestController
public class MainController {

    @Value("${server.port}")
    String port;


    @GetMapping("getHi")//Spring4.3版本以后,@GetMapping等价于@RequestMapping的GET请求方式
    public String getHi() {
        log.info("Hi!,我的port：" + port);
        return "Hi!,我的port：" + port;
    }

    @GetMapping("getMap")//Spring4.3版本以后,@GetMapping等价于@RequestMapping的GET请求方式
    public Map<String,String> getMap() {
        log.info("Hi!,我的port：" + port);
        return Collections.singletonMap("id","100");
    }

    @GetMapping("getObj")//Spring4.3版本以后,@GetMapping等价于@RequestMapping的GET请求方式
    public Person getObj() {
        log.info("Hi!,我的port：" + port);
        Person person=new Person(100,"小六六",port);
        return person;
    }

    @GetMapping("getObj2")//Spring4.3版本以后,@GetMapping等价于@RequestMapping的GET请求方式
    public Person getObj2(String name) {
        log.info("Hi!,我的port：" + port);
        Person person=new Person(100,name,port);
        return person;
    }

    @PostMapping("postObj")//Spring4.3版本以后,@GetMapping等价于@RequestMapping的GET请求方式
    public Person postObj(@RequestBody Person person) {
        log.info("Hi!,我的port：" + port);
        person.setId(100);
        person.setPort(port);
        return person;
    }

    @PostMapping("postLocation")//Spring4.3版本以后,@GetMapping等价于@RequestMapping的GET请求方式
    public URI postLocation(@RequestBody Person person, HttpServletResponse response) throws URISyntaxException {
        log.info("Hi!,我的port：" + port);
        log.info(person.toString());
        log.info(person.toString());
        URI uri = new URI("https://www.baidu.com/s?wd="+UrlUtil.getURLEncoderString(person.getName()));
//        URI uri = new URI("https://www.baidu.com/s?wd="+person.getName().trim());
        response.addHeader("Location", uri.toString());
//        response.addHeader("Content-type", "text/html;charset=UTF-8");
        return uri;
    }

    @Autowired
    HealthStatusService hss;

    /** 手动设置服务的上下线*/
    @GetMapping("health")
    public String health(@RequestParam("status") Boolean status){
        hss.setStatus(status);
        return hss.getStatus();
    }
}


