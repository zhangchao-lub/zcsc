package dachaoge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/15 9:24
 * @descrption
 */
@SpringBootApplication
@EnableZuulProxy
public class ScZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScZuulServerApplication.class,args);
    }
}
