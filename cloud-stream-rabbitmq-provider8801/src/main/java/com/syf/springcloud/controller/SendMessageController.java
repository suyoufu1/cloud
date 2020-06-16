package com.syf.springcloud.controller;

import com.syf.springcloud.service.IMessgeProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    private IMessgeProvider provider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return provider.send();
    }
}
