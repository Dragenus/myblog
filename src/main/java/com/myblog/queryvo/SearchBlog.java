package com.myblog.queryvo;


import lombok.Data;

/**
 * @Description: 搜索博客管理列表
 */
@Data
public class SearchBlog {
    private String title;
    private Long typeId;
}
