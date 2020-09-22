package cn.gs.service;

import cn.gs.model.RoleMap;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleMapService extends IService<RoleMap>{
    public List<RoleMap> getRoleMapList(int id);
}
