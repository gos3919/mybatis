package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(@Param("id") Integer id);
    int deleteById(@Param("id") Integer id);
    int updateUser(User user);
    int insertUser(User user);
}
