package com.liuxh.consumer.controller;

import com.liuxh.consumer.facade.UserFacade;
import com.liuxh.provider.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    UserFacade userFacade;
    @GetMapping("/hello")
    public String hello(){
        User user = userFacade.selectUser();
        return "你好:"+user.getName();
    }
}
