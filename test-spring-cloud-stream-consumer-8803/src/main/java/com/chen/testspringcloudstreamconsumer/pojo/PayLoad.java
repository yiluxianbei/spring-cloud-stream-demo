package com.chen.testspringcloudstreamconsumer.pojo;

import java.io.Serializable;

public class PayLoad implements Serializable {
    private String payLoad;

    public PayLoad(){

    }
    public PayLoad(String payLoad) {
        this.payLoad = payLoad;
    }

    public String getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(String payLoad) {
        this.payLoad = payLoad;
    }

    @Override
    public String toString() {
        return "PayLoad{" +
                "payLoad='" + payLoad + '\'' +
                '}';
    }
}
