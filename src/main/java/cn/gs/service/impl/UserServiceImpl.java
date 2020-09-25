package cn.gs.service.impl;

import cn.gs.mapper.UserMapper;
import cn.gs.model.User;
import cn.gs.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public IPage<User> roleFindAll(Page<User> page,String search) {
        //处理模糊的search
        search = "%"+search+"%";
        IPage<User> result = userMapper.roleFindAll(page,search);
        return result;
    }
    @Autowired
    private UserMapper userMapper;
}
