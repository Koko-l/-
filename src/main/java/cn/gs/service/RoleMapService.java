package cn.gs.service;

import cn.gs.model.RoleMap;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
public interface RoleMapService extends IService<RoleMap>{
    List<RoleMap> getRoleMapList(int id);
}
