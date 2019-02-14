package com.example.demo1.service.impl;

import com.example.demo1.model.User;
import com.example.demo1.mapper.UserMapper;
import com.example.demo1.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser(String id) {
        if(StringUtils.isNotBlank(id)) {
            List<User> resList = new ArrayList<User>();
            resList.add(this.userMapper.selectByPrimaryKey(id));
            return resList;
        }
        return this.userMapper.selectAll();
    }
}
