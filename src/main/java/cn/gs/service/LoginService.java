package cn.gs.service;

import cn.gs.model.User;
public interface LoginService {
    //获取权限列表
    User queryOneByName(String username);
}
