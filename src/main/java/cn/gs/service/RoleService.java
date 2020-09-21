package cn.gs.service;

import cn.gs.model.Role;

import java.util.List;

public interface RoleService {
    public List<Role> queryListById(int id);
}
