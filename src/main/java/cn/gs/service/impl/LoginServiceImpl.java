package cn.gs.service.impl;

import cn.gs.mapper.LoginMapper;
import cn.gs.model.User;
import cn.gs.service.LoginService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
    //获取登录认证需要的用户信息
    @Override
    public User queryOneByName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return loginMapper.selectOne(queryWrapper.eq("username",username).eq("deleted","0"));
    }
    @Autowired
    private LoginMapper loginMapper;
}
