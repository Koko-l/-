package cn.gs.controller;

import cn.gs.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {
    //登录
    @RequestMapping("/login")
    public String login(@RequestParam(name = "username",required = false,defaultValue = "0")String username, @RequestParam(name = "password",required = false,defaultValue = "0") String password, HttpServletRequest request, Model model){
        if(username.equals("0")){
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            return "index";
        }else{
            //生成令牌
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try{
                //使用令牌登录
                subject.login(token);
                //session中存放用户登录信息
                User userLoginInfo = new User();
                User principal = (User) subject.getPrincipal();
                userLoginInfo.setId(principal.getId());
                userLoginInfo.setUsername(principal.getUsername());
                userLoginInfo.setName(principal.getName());
                request.getSession().setAttribute("userLoginInfo",userLoginInfo);
                return "index";
            }catch (UnknownAccountException e){
                model.addAttribute("msg","用户名不存在请重新登录");
                return "login";
            }catch (IncorrectCredentialsException e){
                model.addAttribute("msg","密码错误，请重新登录");
                return "login";
            }
        }
    }
    //登出
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
