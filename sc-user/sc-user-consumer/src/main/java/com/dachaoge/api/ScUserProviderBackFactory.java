package com.dachaoge.api;

import com.dachaoge.entity.Person;
import feign.FeignException;
import feign.RetryableException;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/13 10:42
 * @descrption
 */
@Component
@Slf4j
public class ScUserProviderBackFactory implements FallbackFactory<ConsumerApi> {
    @Override
    public ConsumerApi create(Throwable cause) {
        return new ConsumerApi() {
            @Override
            public Map<Integer, String> getMap(Integer id) {
                return null;
            }

            @Override
            public Map<Integer, String> getMap2(Integer id, String name) {
                return null;
            }

            @Override
            public Map<Integer, String> getMap3(Map<String, Object> map) {
                return null;
            }

            @Override
            public Map<Integer, String> postMap(Map<String, Object> map) {
                return null;
            }

            @Override
            public String getUp() {
                log.warn(cause.toString());
                if(cause instanceof FeignException.InternalServerError){
                    return "远程服务器500";
                }
                cause.printStackTrace();
                log.error(ToStringBuilder.reflectionToString(cause));
                return cause.getMessage();
            }

            @Override
            public String alive() {
                log.warn(cause.toString());
                if(cause instanceof RetryableException){
                    return "远程服务连接超时";
                }
                cause.printStackTrace();
                log.error(ToStringBuilder.reflectionToString(cause));
                return cause.getMessage();
            }

            @Override
            public String register() {
                return null;
            }

            @Override
            public String getById(Integer id) {
                return null;
            }

            @Override
            public Person postPerson(Person person) {
                return null;
            }
        };
    }
}
