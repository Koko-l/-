package cn.gs.config;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSessionStorageEvaluator;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroConfig{
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        Map<String,String> filterMap = new LinkedHashMap<>();
        //给controller增加权限
        //登录拦截
        filterMap.put("/","authc");
        filterMap.put("/index.html","authc");
        //放行静态资源
        filterMap.put("/static/**","anon");
        bean.setFilterChainDefinitionMap(filterMap);
        //登录拦截跳转页面
        bean.setLoginUrl("/toLogin");
        //登录失败的页面
        bean.setUnauthorizedUrl("/toLogin");
        //登录成功的页面
        bean.setSuccessUrl("/");
        return bean;
    }
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm,DefaultWebSessionManager sessionManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        defaultWebSecurityManager.setSessionManager(sessionManager);
        return defaultWebSecurityManager;
    }
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //整合thymeleaf模版
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
    //首次访问问题解决方案
    @Bean
    public DefaultWebSessionManager  sessionManager(){
        DefaultWebSessionManager sessionManager= new DefaultWebSessionManager();
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }
}
