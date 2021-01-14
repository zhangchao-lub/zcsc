package com.dachaoge.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/13 13:56
 * @descrption
 */
@Service
public class RestService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "back")
    public String alive(){
        String url="http://http;//sc-user-provider/alive";
        String forObject = restTemplate.getForObject(url, String.class);

        return forObject;
    }

    public String back(){
        return "战斗力无限";
    }
}
