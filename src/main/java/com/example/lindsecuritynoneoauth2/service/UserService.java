package com.example.lindsecuritynoneoauth2.service;

import com.example.lindsecuritynoneoauth2.domain.CommonResource;
import com.example.lindsecuritynoneoauth2.domain.CommonUserDetails;
import com.example.lindsecuritynoneoauth2.framework.exception.SecurityException;
import com.example.lindsecuritynoneoauth2.framework.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lind
 * @date 2024/4/17 8:53
 * @since 1.0.0
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = loadUserByUsername(username);

            if (!userDetails.isEnabled()) {
                throw new SecurityException("帐号已被禁用");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            throw new SecurityException("登录异常:" + e.getMessage());
        }
        return token;
    }

    public UserDetails loadUserByUsername(String username) {
        // 正常账号
        if (username.equals("admin")) {
            List<CommonResource> list = new ArrayList<>();
            list.add(CommonResource.builder().url("/hello").id(1L).name("hello").build());
            return CommonUserDetails.builder().username(username).status(1).resourceList(list).build();
        }
        // 禁用账号
        if (username.equals("lind")) {
            return CommonUserDetails.builder().username(username).status(0).build();
        }
        throw new SecurityException("用户未找到");
    }

}
