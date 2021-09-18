package com.myblog.entity;

import lombok.Data;
/* @Description: 相册实体类
*/
@Data
public class Picture {
    private Long id;
    private String picturename;
    private String picturetime;
    private String pictureaddress;
    private String picturedescription;
}
