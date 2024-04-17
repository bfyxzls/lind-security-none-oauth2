package com.example.lindsecuritynoneoauth2.config;

import com.example.lindsecuritynoneoauth2.framework.component.DynamicSecurityService;
import com.example.lindsecuritynoneoauth2.domain.CommonResource;
import com.example.lindsecuritynoneoauth2.service.ResourceService;
import com.example.lindsecuritynoneoauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * mall-security模块相关配置
 * Created by macro on 2019/11/9.
 */
@Configuration
public class MySecurityConfig {

    @Autowired
    private UserService adminService;
    @Autowired
    private ResourceService resourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminService.loadUserByUsername(username);
    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
                List<CommonResource> resourceList = resourceService.listAll();
                if (resourceList != null) {
                    for (CommonResource resource : resourceList) {
                        map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
                    }
                }

                return map;
            }
        };
    }
}
