package com.example.lindsecuritynoneoauth2.framework.component;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * 动态权限相关业务接口
 * 由使用者进行实现，使用者可从缓存或者数据库中读取资源列表.
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     * key是url,value是id:name
     */
    Map<String, ConfigAttribute> loadDataSource();
}
