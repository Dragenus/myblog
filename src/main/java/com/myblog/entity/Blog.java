package com.myblog.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 博客实体类
 */
@Data
public class Blog {

    private Long id;
    private String title;
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private Integer commentCount;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    private Date createTime;
    private Date updateTime;
    private String description;

    private Type type;
    private User user;
    private Long typeId;
    private Long userId;
    private List<Comment> comments = new ArrayList<>();

}