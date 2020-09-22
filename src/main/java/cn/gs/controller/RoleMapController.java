package cn.gs.controller;

import cn.gs.model.RoleMap;
import cn.gs.service.RoleMapService;
import cn.gs.service.UserService;
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
    public String queryRoleMap(Model model){
        model.addAttribute("jurisdiction_list",userService.roleFindAll());
        return "jurisdiction_list";
    }
    @Autowired
    private RoleMapService roleMapService;
    @Autowired
    private UserService userService;
}
