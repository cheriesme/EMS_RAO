package com.example.ems.Service;

import com.example.ems.Entity.sys_role;
import com.example.ems.Exception.paramException;
import com.example.ems.Utils.BeanValidator;
import com.example.ems.mapper.sys_roleMapper;
import com.example.ems.param.roleParam;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 14:49
 */
@Service
@Repository
public class sysroleService {
    @Resource
    private sys_roleMapper sysRoleMApper;
    public void save(roleParam param){
        BeanValidator.check(param);
        if (checkExist(param.getName())){
            throw new paramException("该角色已存在");
        }
        sys_role role = sys_role.builder().id(param.getId()).name(param.getName()).build();
        role.setOperator("system");
        role.setOperateip("127.0.0.1");
        role.setOperatetime(new Date());
        sysRoleMApper.insertSelective(role);
    }

    private boolean checkExist(String name) {
        return sysRoleMApper.selectByName(name).size()>0;
    }
}
