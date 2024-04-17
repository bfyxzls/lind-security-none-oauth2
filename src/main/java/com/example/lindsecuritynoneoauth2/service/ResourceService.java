package com.example.lindsecuritynoneoauth2.service;

import com.example.lindsecuritynoneoauth2.domain.CommonResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lind
 * @date 2024/4/17 9:06
 * @since 1.0.0
 */
@Service
public class ResourceService {
    public List<CommonResource> listAll() {

        List<CommonResource> list=new ArrayList<>();
        list.add(CommonResource.builder().url("/hello").id(1L).name("hello").build());
        return list;
    }
}
