package com.example.lindsecuritynoneoauth2.controller;

import com.example.lindsecuritynoneoauth2.framework.api.CommonResult;
import com.example.lindsecuritynoneoauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lind
 * @date 2024/4/17 8:53
 * @since 1.0.0
 */
@RestController
public class CommonController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public CommonResult login(String username, String password) {
        String token = userService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }
}
