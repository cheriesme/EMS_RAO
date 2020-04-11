package com.example.ems.controller;

import com.example.ems.Entity.sys_role;
import com.example.ems.Entity.syspermission;
import com.example.ems.Service.sysroleService;
import com.example.ems.mapper.SyspermissionMapper;
import com.example.ems.mapper.sys_roleMapper;
import com.example.ems.param.roleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 14:38
 */
@Controller
@RequestMapping("/role")
public class roleController {
    @Resource
    private sys_roleMapper roleMapper;
    @Resource
    private SyspermissionMapper permission;
    @Autowired
    private sysroleService sysroleService;
    @RequestMapping("/save.page")
    public String save(roleParam param){
        sys_role sysRole =roleMapper.selectend();
        int id = sysRole.getId();
        param.setId(id+1);
        sysroleService.save(param);
        return "redirect:/role/getrole.page";
    }
    @RequestMapping("/getrole.page")
    public String get(ModelMap map){
        List<sys_role> sysRoleList= roleMapper.getAll();
        List<syspermission> permissionAllList = permission.getAll();
        map.addAttribute("perList",permissionAllList);
        map.addAttribute("sysrolelist",sysRoleList);
        return "role_table";
    }
    @RequestMapping("/delete.page/{id}")
    public String delete(@PathVariable("id") Integer id){
        roleMapper.deleteByPrimaryKey(id);
        return "redirect:/role/getrole.page";
    }
}
