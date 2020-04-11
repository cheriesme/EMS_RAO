package com.example.ems.Service;

import com.example.ems.Entity.syspermission;
import com.example.ems.Entity.syspermodel;
import com.example.ems.Exception.paramException;
import com.example.ems.Utils.BeanValidator;
import com.example.ems.Utils.levelUtil;
import com.example.ems.mapper.SyspermissionMapper;
import com.example.ems.mapper.SyspermodelMapper;
import com.example.ems.param.PermissionParam;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 9:00
 */
@Service
@Repository
public class SyspermissionService {
    @Resource
    private SyspermissionMapper syspermissionMapper;
    @Resource
    private SyspermodelMapper syspermodelMapper;
    public void save(PermissionParam param){
        BeanValidator.check(param);
        if (CheckExist(param.getName())){
            throw new paramException("该用户已存在");
        }
        syspermission sysPermission = syspermission.builder().id(param.getId()).name(param.getName()).permodelId(param.getModelid()).level(param.getLevel()).seq(param.getSeq()).build();
        sysPermission.setOperator("system");
        sysPermission.setOperateTime(new Date());
        sysPermission.setOperateIp("127.0.0.1");
        sysPermission.setId(param.getId());
        sysPermission.setLevel(levelUtil.calculatelevel(getLevel(param.getModelid()),param.getId()));
        syspermissionMapper.insertSelective(sysPermission);
    }

    public String getLevel(Integer modelid) {
        syspermodel syspermodel = syspermodelMapper.selectByPrimaryKey(modelid);
        if (syspermodel == null){
            return null;
        }else {
            return syspermodel.getLevel();
        }
    }

    private boolean CheckExist(String name) {
        return syspermissionMapper.selectByname(name).size()>0;
    }
}
