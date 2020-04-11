package com.example.ems.controller;

import com.example.ems.Entity.syspermodel;
import com.example.ems.Service.SyspermodelService;
import com.example.ems.mapper.SyspermodelMapper;
import com.example.ems.param.permodelParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 10:09
 */
@Controller
@RequestMapping("/permodel")
public class permodelcontroller {
    @Autowired
    private SyspermodelService syspermodelService;
    @Resource
    private SyspermodelMapper syspermodelMapper;
    @RequestMapping("save.page")
    public String save(permodelParam param){
        syspermodel syspermodel = syspermodelMapper.selectend();
        int id = syspermodel.getId();
        param.setId(id+1);
        syspermodelService.save(param);
               return "redirect:/permission/getpermission.page";
    }
}
