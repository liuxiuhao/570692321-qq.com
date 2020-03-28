package com.liuxh.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liuxh.provider.api.service.UserService;
import com.liuxh.provider.api.model.User;
import com.liuxh.provider.common.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用户查询
 */
@RestController
@Slf4j
public class UserController implements UserService {
    static final AtomicInteger countReq = new AtomicInteger();
    @SentinelResource(value = "selectUser",blockHandler = "handleException",blockHandlerClass = ExceptionUtil.class)
    @Override
    public User selectUser() {
        log.info(new Date()+"receive res:"+countReq.incrementAndGet());
        if (Math.random()<0.5){
          // throw new RuntimeException("有异常了");
        }
        User user = new User("liuXH",28);
        return user;
    }
    public User fallbackHandle(Throwable  e){
        log.info("执行 fallbackHandle");
        e.printStackTrace();
        return  new User("block",000);
    }
    public User blockHandler(BlockException  e){
        log.info("执行 blockHandler");
        return  new User("block",000);
    }
}
