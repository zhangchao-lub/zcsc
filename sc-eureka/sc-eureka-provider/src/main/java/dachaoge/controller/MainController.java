package dachaoge.controller;

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

    @GetMapping("getHi")//Spring4.3版本以后,@GetMapping等价于@RequestMapping的GET请求方式
    public String getHi() {
        log.info("hi");
        return "hi";
    }

    @GetMapping("client")
    public String client() {
        List<String> services = client.getServices();
        return services.toString();
    }

}


