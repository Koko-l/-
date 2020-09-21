package cn.gs;

import cn.gs.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
@Autowired
    RoleMapper roleMapper;
    @Test
    void contextLoads() {
        roleMapper.queryListById(1);
    }

}
