package cn.gs;

import cn.gs.mapper.UserMapper;
import cn.gs.service.RoleMapService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
@Autowired
    RoleMapService roleMapService;
@Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.roleFindAll());
    }

}
