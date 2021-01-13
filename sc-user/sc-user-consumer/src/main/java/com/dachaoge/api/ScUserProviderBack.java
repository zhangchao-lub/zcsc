package com.dachaoge.api;

import com.dachaoge.entity.Person;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/12 17:45
 * @descrption
 */
@Component
public class ScUserProviderBack implements ConsumerApi {

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
        return null;
    }

    @Override
    public String alive() {
        return "降级了";
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
}
