package com.myblog.annotation;

import java.lang.annotation.*;
/*
*   自定义注解，指定时间内请求次数
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface AccessLimit {
    int seconds();
    int maxCount();
}
