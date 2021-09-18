package com.myblog.queryvo;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 编辑修改文章实体类
 */
@Data
public class ShowBlog {
    private Long id;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean published;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentabled;
    private Date updateTime;
}
