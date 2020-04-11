package com.example.ems.controller;

import com.example.ems.Entity.sysuser;
import com.example.ems.mapper.SysuserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther raoyanping
 * @Date 2020/4/7 14:47
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private SysuserMapper sysuserMapper;
    @RequestMapping("/getuser.page")
    public String getuserlist(ModelMap map, HttpSession session){
        List<sysuser> sysuserList= sysuserMapper.getall();
        map.addAttribute("userlist",sysuserList);
        session.setAttribute("size",sysuserList.size());
        System.out.println(sysuserList);
//        sysuser user = sysuserMapper.selectByPrimaryKey(1);
//        map.addAttribute("user",user);
        return "table";
    }
}
