package com.dachaoge.controller;

import com.dachaoge.api.ConsumerApi;
import com.dachaoge.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/7 15:37
 * @descrption
 */

@RestController
@Slf4j
public class MainController {

    @Autowired
    ConsumerApi api;

    @GetMapping("alive")
    public String alive(){
        return api.alive();
    }
    @GetMapping("register")
    public String register(){
        return api.register();
    }

    @GetMapping("getById")
    public String getById(Integer id){
        return api.getById(id);
    }
    /**
     *
     * 降级
     *
     *
     * 隔离
     *
     * 熔断
     *
     * 自己写
     *
     *
     * try{
     *
     *     1.   发起向服务方的请求;
     *     		1.1 判断连接超时
     *     			-> 这次请求 记录到服务里
     *     		http请求  线程消耗
     *
     *
     *     		map(URI,线程数)
     *     		线程池（线程数）
     *        阈值 阀值
     *
     *        计数 连续失败次数 达到阈值
     *        count ++；
     *     if(count == 10){
     *
     *     new romdom  == 1  按时间
     *       发请求
     *
     *
     *     	throw exception;
     *     }
     *
     *
     *         请求/不请求/半请求
     *         开      关         半开
     *
     *     if （当前线程满了）{
     *     	throw exception
     *     }
     *
     *
     *     		1.2 尝试向其他服务器发起请求
     *
     *
     *     注解
     *
     *
     *     2. 还是没成功
     *
     *     }catch(Exception e){
     *
     *     	1.	避免返回不友好的错误信息
     *     			-> 好看点儿的页面  重试按钮 联系邮箱
     *
     *
     *     	2.	return 另外一个东西 写到MQ里 admin 发个邮件
     *
     *     		return "客观稍后再来"；
     *
     *     }
     *
     *
     *     Hystrix 干的就是这件事儿
     */

    //	@GetMapping("/vip")
//	public String vip() {
//
//		return mapi.getVip();
//	}
//
    @GetMapping("/map")
    public Map<Integer, String> map(Integer id) {
        log.info(id.toString());
        return api.getMap(id);
    }

    @GetMapping("/map2")
    public Map<Integer, String> map2(Integer id,String name) {
        log.info(id.toString());
        return api.getMap2(id,name);
    }


    @GetMapping("/map3")
    public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
        HashMap<String, Object> map1 = new HashMap<>(2);

        map1.put("id", 2000);
        map1.put("name", "凯");
        return api.getMap3(map1);
    }


    @GetMapping("/map4")
    public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
        log.info(map.toString());
        return api.postMap(map);
    }




    @GetMapping("/postPerson")
    public Person postPerson(@RequestParam Map<String, Object> map) {

        log.info("map"+map.toString());

        Person person = new Person();
        person.setId(Integer.parseInt(map.get("id").toString()));
        person.setName("xxoo");
        log.info("Person"+person);
        return api.postPerson(person);
    }

}
