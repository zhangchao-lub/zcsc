package com.dachaoge.api;

import com.dachaoge.entity.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/8 10:19
 * @descrption
 */
@RequestMapping("user")
public interface UserApi {

    /**
     * 查看当前服务状态
     * @return
     */
    @GetMapping("alive")
    public String alive();

    @GetMapping("register")
    public String register();

    @GetMapping("getById")
    public String getById(@RequestParam("id") Integer id);

    @PostMapping("/postPerson")
    public Person postPerson(@RequestBody Person person);

}
