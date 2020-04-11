package com.example.ems.controller;

import com.example.ems.Entity.syspermission;
import com.example.ems.Entity.syspermodel;
import com.example.ems.Service.SyspermissionService;
import com.example.ems.mapper.SyspermissionMapper;
import com.example.ems.mapper.SyspermodelMapper;
import com.example.ems.param.PermissionParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther raoyanping
 * @Date 2020/4/9 16:37
 */
@Controller
@RequestMapping("/permission")
public class permissionController {
    @Autowired
    private SyspermissionService syspermissionService;
    @Resource
    private SyspermissionMapper syspermissionMapper;
    @Resource
    private SyspermodelMapper syspermodelMapper;
    @RequestMapping("/getpermission.page")
    public String getpermission(ModelMap map){
        List<syspermission> syspermissionList = syspermissionMapper.getAll();
        map.addAttribute("permissionList",syspermissionList);
        List<syspermodel> syspermodelList = syspermodelMapper.getAll();
        map.addAttribute("permodellist",syspermodelList);
        return "permission_table";
    }
    @RequestMapping("/save.page")
    public String save(PermissionParam param){
        syspermission syspermission = syspermissionMapper.selectEnd();
        int id = syspermission.getId();
        param.setId(id+1);
        syspermissionService.save(param);
        param.setId(id+1);
        return "redirect:/permission/getpermission.page";
    }
    @RequestMapping("/delete.page/{id}")
    public String delete(@PathVariable("id") Integer id){
        syspermissionMapper.deleteByPrimaryKey(id);
        return "redirect:/permission/getpermission.page";
    }
}
