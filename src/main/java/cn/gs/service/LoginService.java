package cn.gs.service;

import cn.gs.model.User;

public interface LoginService {
    //获取权限列表
    public User queryOneByName(String username);
}
