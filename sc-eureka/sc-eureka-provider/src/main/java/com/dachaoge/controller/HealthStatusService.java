package com.dachaoge.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/1/5 10:27
 * @descrption
 */
@Service
public class HealthStatusService implements HealthIndicator {
    //服务状态
    private Boolean status=true;

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public Health health() {
        //TODO
        if(status){
            return new Health.Builder().up().build();
        }else {
            return new Health.Builder().down().build();
        }
    }

    public String getStatus() {
        // TODO Auto-generated method stub
        return this.status.toString();
    }

}
