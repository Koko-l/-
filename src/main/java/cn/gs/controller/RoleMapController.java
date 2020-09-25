package cn.gs.controller;

import cn.gs.model.RoleMap;
import cn.gs.model.User;
import cn.gs.service.RoleMapService;
import cn.gs.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/roleMap")
public class RoleMapController {
    private final int SIZE=1*5;
    @RequestMapping("/update")
    @ResponseBody
    public boolean updateRoleMap(HttpServletRequest request){
        String idf = request.getParameter("id");
        String msg_hold = request.getParameter("msg_hold");
        String class_hold = request.getParameter("class_hold");
        String order_hold = request.getParameter("order_hold");
        String history_hold = request.getParameter("history_hold");
        String user_hold = request.getParameter("user_hold");
        if(idf!=null&&idf!=""){
            int id  = Integer.parseInt(idf);
            List<RoleMap> roleMaps = roleMapService.getRoleMapList(id);
            for (RoleMap r: roleMaps) {
                if(r.getRoleId().equals(1)){
                    r.setDeleted(Integer.parseInt(msg_hold));
                }
                if(r.getRoleId().equals(2)){
                    r.setDeleted(Integer.parseInt(class_hold));
                }
                if(r.getRoleId().equals(3)){
                    r.setDeleted(Integer.parseInt(order_hold));
                }
                if(r.getRoleId().equals(4)){
                    r.setDeleted(Integer.parseInt(history_hold));
                }
                if(r.getRoleId().equals(5)){
                    r.setDeleted(Integer.parseInt(user_hold));
                }
            }
            return roleMapService.updateBatchById(roleMaps);
        }
        return false;
    }
    @RequestMapping("/findAll")
    public String queryRoleMap(Model model,HttpServletRequest request){
        //模糊查询
        String search = request.getParameter("search");
        //处理没有传search的情况
        if(search==null){
            search="";
        }
        String currentf = request.getParameter("current");
        //当前页
        int current = 1;
        if(currentf!=null&&currentf!=""){
            current = Integer.parseInt(currentf);
        }
        Page<User> page = new Page(current,SIZE);
        IPage<User> result = userService.roleFindAll(page,search);
        List<User> jurisdiction_list = result.getRecords();
        model.addAttribute("jurisdiction_list",jurisdiction_list);
        //获取最大页
        int MaxPage = (int)result.getPages();
        model.addAttribute("MaxPage",MaxPage);
        //处理上一页
        int prev = 1;
        if(current>1){
            prev=current-1;
        }
        //处理下一页
        int next = MaxPage;
        if(next<MaxPage){
            next=current+1;
        }
        model.addAttribute("prev",prev);
        model.addAttribute("current",current);
        model.addAttribute("next",next);
        //存一个search
        model.addAttribute("search",search);
        return "jurisdiction_list";
    }
    @Autowired
    private RoleMapService roleMapService;
    @Autowired
    private UserService userService;
}
