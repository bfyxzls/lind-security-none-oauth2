package com.example.lindsecuritynoneoauth2.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class CommonResource implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Date createTime;
    private String name;
    private String url;
    private String description;
    private Long categoryId;
}
