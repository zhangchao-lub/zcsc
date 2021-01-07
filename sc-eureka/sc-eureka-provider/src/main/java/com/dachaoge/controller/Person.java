package com.dachaoge.controller;

import lombok.Data;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/6 16:33
 * @descrption
 */
@Data
public class Person {

    private int id;
    private String name;
    private String port;

    public Person(){

    }

    public Person(int id, String name, String port) {
        this.id = id;
        this.name = name;
        this.port = port;
    }
}
