package com.example.lindsecuritynoneoauth2;

import com.example.lindsecuritynoneoauth2.framework.api.CommonResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LindSecurityNoneOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(LindSecurityNoneOauth2Application.class, args);
    }

    @GetMapping("/hello")
    public CommonResult<String> hello() {
        return CommonResult.success("hello world");
    }
}
