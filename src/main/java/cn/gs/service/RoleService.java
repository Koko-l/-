package cn.gs.service;

import cn.gs.model.Role;

import java.util.List;
public interface RoleService {
    List<Role> queryListById(int id);
}
