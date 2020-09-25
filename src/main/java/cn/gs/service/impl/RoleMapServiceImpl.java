package cn.gs.service.impl;

import cn.gs.mapper.RoleMapMapper;
import cn.gs.model.RoleMap;
import cn.gs.service.RoleMapService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleMapServiceImpl extends ServiceImpl<RoleMapMapper,RoleMap> implements RoleMapService {

    @Override
    public List<RoleMap> getRoleMapList(int id) {
        return roleMapMapper.selectList(new QueryWrapper<RoleMap>().eq("user_id",id));
    }
    @Autowired
    private RoleMapMapper roleMapMapper;
}
