package com.syf.springcloud.service.impl;

import com.syf.springcloud.service.IMessgeProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;


@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl  implements IMessgeProvider {
    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("uuid = " + uuid);
        return null;
    }
}
