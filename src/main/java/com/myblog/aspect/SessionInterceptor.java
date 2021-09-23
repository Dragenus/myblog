package com.myblog.aspect;

import com.alibaba.fastjson.JSONObject;
import com.myblog.annotation.AccessLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myblog.util.Response;


import java.util.concurrent.TimeUnit;



@Component
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断请求是否属于方法的请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            // 获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (null == accessLimit) {
                return true;
            }

            // 指定时间内
            int seconds = accessLimit.seconds();
            // 允许请求次数
            int maxCount = accessLimit.maxCount();

            String ip=request.getRemoteAddr();
            String key = request.getServletPath() + ":" + ip ;

            // 从redis中获取用户访问的次数
            Integer count = (Integer) redisTemplate.opsForValue().get(key);

            System.out.println(count);

            if (null == count || -1 == count) {
                // 第一次访问
                redisTemplate.opsForValue().set(key, 1,seconds, TimeUnit.SECONDS);
                return true;
            }

            if (count < maxCount) {
                // count加1
                count = count+1;
                redisTemplate.opsForValue().set(key, count,0);
                return true;
            }

            // 超出访问次数
            if (count >= maxCount) {
                // response 返回 json 请求过于频繁请稍后再试
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                Response result = new Response<>();
                result.setCode("9999");
                result.setMsg("操作过于频繁");
                Object obj = JSONObject.toJSON(result);
                response.getWriter().write(JSONObject.toJSONString(obj));
                return false;
            }
        }

        return true;
    }
}