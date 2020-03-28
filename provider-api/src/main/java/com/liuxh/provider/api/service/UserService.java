package com.liuxh.provider.api.service;

import com.liuxh.provider.api.model.User;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户信息
 */
public interface UserService {
    @GetMapping("/api/selectUser")
    public User selectUser();
}
