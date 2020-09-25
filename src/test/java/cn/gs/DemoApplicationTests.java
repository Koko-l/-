package cn.gs;
import cn.gs.mapper.UserMapper;
import cn.gs.model.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
@Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        Page page =new Page<>(1,5);
        System.out.println(userMapper.roleFindAll(page,"").getRecords().toString());
    }

}
