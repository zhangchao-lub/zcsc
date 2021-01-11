package com.dachaoge.api;

import com.dachaoge.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/7 16:17
 * @descrption
 */

//此处由于结合了eureka，所以name是 虚拟主机名，默认服务名，请求时 会将它解析成注册表中的服务。
//不结合eureka，就是自定义一个client名字。就用url属性指定 服务器列表。url=“http://ip:port/”
//此时的name作用就是创建负载均衡器。
//也可以添加@RequestMapping
/**
 * 这种方式 跟RestTemplate
 *
 * 没有代码侵入
 *
 * 方便做异构系统
 */

//@FeignClient(name = "ooxx",url = "http://localhost:7301")
@FeignClient(name = "sc-user-provider")
public interface ConsumerApi extends UserApi {
    /**
     * 这里 getMapping 是给Feign看的 get请求 sc-user-provider/getMap?id={1}
     * @RequestParam("id") 也是给Feign看的
     *
     * HttpClient Http协议
     * @param id
     * @return
     */
    @GetMapping("/getMap")
    Map<Integer, String> getMap(@RequestParam("id") Integer id);



    @GetMapping("/getMap2")
    Map<Integer, String> getMap2(@RequestParam("id") Integer id,@RequestParam("name") String name);

    @GetMapping("/getMap3")
    Map<Integer, String> getMap3(@RequestParam Map<String, Object> map);

    @PostMapping("/postMap")
    Map<Integer, String> postMap(Map<String, Object> map);

}
