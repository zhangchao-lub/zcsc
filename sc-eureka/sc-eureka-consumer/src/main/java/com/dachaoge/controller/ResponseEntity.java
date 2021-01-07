package com.dachaoge.controller;

import lombok.Data;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/7 13:59
 * @descrption
 */
@Data
public class ResponseEntity {

    // 状态码
    int code;
    Object date;
    String msg;

}
