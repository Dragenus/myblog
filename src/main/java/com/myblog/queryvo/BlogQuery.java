package com.myblog.queryvo;


import com.myblog.entity.Type;
import lombok.Data;

import java.util.Date;
/*
* @Description: 查询博客列表
* */

@Data
public class BlogQuery {
    private Long id;
    private String title;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
}
