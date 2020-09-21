package cn.gs.config;

import cn.gs.model.Role;
import cn.gs.model.User;
import cn.gs.service.impl.LoginServiceIMPL;
import cn.gs.service.impl.RoleServiceIMPL;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User principal = (User) subject.getPrincipal();
        //0代表超级管理员 1代表管理员 2代表普通用户
        if(principal.getJurisdiction().equals(0)){
            info.addStringPermission("super_admin");
        }
        if(principal.getJurisdiction().equals(1)){
            info.addStringPermission("admin");
            //获取登录用户权限列表
            List<Role> roleList = roleServiceIMPL.queryListById(principal.getId());
            for (Role r:roleList) {
                info.addStringPermission(r.getRoleName());
            }
        }
        return info;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user =loginServiceIMPL.queryOneByName(token.getUsername());
        if(user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
    @Autowired
    private LoginServiceIMPL loginServiceIMPL;
    @Autowired
    private RoleServiceIMPL roleServiceIMPL;
}
