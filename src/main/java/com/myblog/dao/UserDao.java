package com.myblog.dao;

import com.myblog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description: 用户持久层接口
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * @Description:
     */
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}