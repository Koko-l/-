package cn.gs.service;

import cn.gs.model.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public interface UserService {
    IPage<User> roleFindAll(Page<User> page,String search);
}
