package com.dachaoge.controller;

import com.dachaoge.api.UserApi;
import com.dachaoge.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/7 15:37
 * @descrption
 */
@RestController
@Slf4j
public class UserController implements UserApi {

    @Value("${server.port}")
    String port;


    private AtomicInteger count = new AtomicInteger();


    @Override
    @GetMapping("alive")
    public String alive() {
        try {
            log.info("准备睡");

            Thread.sleep(8000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int i = count.getAndIncrement();
        log.info(port + " 好的 ====第：" + (i+1) + "次调用");
        return "port:" + port;

    }

    @GetMapping("getUp")
    public String getUp() {
            log.info("起床了");

            int i=1/0;


        return "port:" + port;

    }

    @Override
    @GetMapping("register")
    public String register() {
        return "login in successfully";
    }

    @Override
    @GetMapping("getById")
    public String getById(@RequestParam("id")Integer id) {
        switch (id) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            default:
                return null;
        }
    }

    @GetMapping("getMap")
    public Map<Integer, String> getMap(@RequestParam("id") Integer id) {

        log.info(String.valueOf(id));
        return Collections.singletonMap(id, "妄想山海");
    }
    @GetMapping("getMap2")
    public Map<Integer, String> getMap2(Integer id,String name) {
        // TODO Auto-generated method stub
        log.info(String.valueOf(id));
        return Collections.singletonMap(id, name);
    }

    @GetMapping("getMap3")
    public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
        // TODO Auto-generated method stub
        log.info(map.toString());
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }


    @PostMapping("postMap")
    public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
        // TODO Auto-generated method stub
        log.info(map.toString());
        return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
    }

    @Override
    @PostMapping("postPerson")
    public Person postPerson(Person person) {
        log.info(person.toString());
        log.info(ToStringBuilder.reflectionToString(person));
        return person;
    }



}
