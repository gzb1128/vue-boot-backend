package com.webapp.service;

import com.webapp.dao.UserMapper;
import com.webapp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserMapper userMapper;
    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public boolean getUserLoginInfo(String name, String pwd) {
        User user = userMapper.getUserByName(name);
        if(user != null) {
            return user.getPwd().equals(pwd);
        } else {
            return false;
        }
    }
}
