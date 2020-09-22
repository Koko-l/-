package cn.gs.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Date;

//权限与用户关联表
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_role_map")
public class RoleMap implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Date createTime;
    private Date updateTime;
    private Integer deleted;
}
