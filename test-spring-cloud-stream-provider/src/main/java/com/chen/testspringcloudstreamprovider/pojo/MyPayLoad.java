package com.chen.testspringcloudstreamprovider.pojo;

import java.io.Serializable;

public class MyPayLoad implements Serializable {
    private String payLoad;

    public MyPayLoad(){

    }
    public MyPayLoad(String payLoad) {
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
        return "MyPayLoad{" +
                "payLoad='" + payLoad + '\'' +
                '}';
    }
}
