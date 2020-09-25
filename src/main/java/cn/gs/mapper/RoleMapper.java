package cn.gs.mapper;

import cn.gs.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Mapper
@Repository
public interface RoleMapper {
    @Transactional
    List<Role> queryListById(@Param("id")int id);
}
