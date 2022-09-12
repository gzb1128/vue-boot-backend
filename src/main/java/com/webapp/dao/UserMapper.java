package com.webapp.dao;

import com.webapp.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Select("select * from user where id = #{id}")
    public User getUserById(int id);
    @Select("select * from user where name = #{name}")
    public User getUserByName(String name);
    @Select("select * from user")
    public List<User> getUsers();
}
