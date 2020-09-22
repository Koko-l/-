package cn.gs.service.impl;

import cn.gs.mapper.UserMapper;
import cn.gs.model.User;
import cn.gs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceIMPL implements UserService {
    @Override
    public List<User> roleFindAll() {
        return userMapper.roleFindAll();
    }
    @Autowired
    private UserMapper userMapper;
}
