package com.myblog.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 友链实体类
 */
@Data
public class FriendLink {

    private Long id;
    private String blogname;
    private String blogaddress;
    private String pictureaddress;
    private Date createTime;

}