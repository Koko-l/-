package cn.gs.service;

import cn.gs.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> roleFindAll();
}
