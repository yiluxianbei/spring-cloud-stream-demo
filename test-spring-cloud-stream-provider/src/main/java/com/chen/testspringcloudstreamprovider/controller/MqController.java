package com.chen.testspringcloudstreamprovider.controller;

import com.chen.testspringcloudstreamprovider.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqController {
    @Autowired
    private MqService mqService;
    @GetMapping(value = "/mq")
    public boolean sendMessage()
    {
        return mqService.send();
    }
    @GetMapping("/mydelayed")
    public boolean mydelayed(){
        return mqService.delayed();
    }
}
