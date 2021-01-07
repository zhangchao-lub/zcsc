package com.dachaoge.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/7 13:59
 * @descrption
 */
@Slf4j
public class LoggingClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        log.info("拦截啦！！！");
        log.info(request.getURI().toString());

        ClientHttpResponse response = execution.execute(request, body);

        log.info(response.getHeaders().toString());
        return response;

    }
}
