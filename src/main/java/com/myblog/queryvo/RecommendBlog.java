package com.myblog.queryvo;

import lombok.Data;

/**
 * @Description: 推荐博客数据实体类
 */
@Data
public class RecommendBlog {
    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;

}
