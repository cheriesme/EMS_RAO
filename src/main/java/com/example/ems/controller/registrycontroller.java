package com.example.ems.controller;

import com.example.ems.Entity.sys_role;
import com.example.ems.Entity.sysdept;
import com.example.ems.Service.SysUserService;
import com.example.ems.common.Jsondata;
import com.example.ems.mapper.SysdeptMapper;
import com.example.ems.mapper.SysuserMapper;
import com.example.ems.mapper.sys_roleMapper;
import com.example.ems.param.UserParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.constraints.Size;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/index")
public class registrycontroller {
    @Resource
    private SysdeptMapper sysdeptMapper;
    @Resource
    private sys_roleMapper roleMapper;
@Autowired
private SysUserService sysUserService;
@RequestMapping("/register.json")
@ResponseBody
public Jsondata registry(UserParam param){
    System.out.println(param);
  sysUserService.registry(param);
  return Jsondata.success(param,"保存成功！");
}
@RequestMapping("/getdept.page")
    public String getdept(ModelMap map){
    List<sysdept> dept =sysdeptMapper.getAllDept();
    List<sys_role> roleList = roleMapper.getAll();
    map.addAttribute("rolelist",roleList);
    map.addAttribute("deptlist",dept);
    return "register";
}
@RequestMapping("/index.page")
    public String login(ModelMap map){
        return "index";
    }

}
