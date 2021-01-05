package dachaoge.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @RefreshScope
    public String getHi() {
        log.info("Hi!,我的port：" + port);
        return "Hi!,我的port：" + port;
    }


}


