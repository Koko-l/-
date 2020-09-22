package cn.gs.service.impl;

import cn.gs.mapper.RoleMapper;
import cn.gs.model.Role;
import cn.gs.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceIMPL implements RoleService {
    //获取权限列表
    @Override
    public List<Role> queryListById(int id) {
        return roleMapper.queryListById(id);
    }
    @Autowired
    private RoleMapper roleMapper;
}
