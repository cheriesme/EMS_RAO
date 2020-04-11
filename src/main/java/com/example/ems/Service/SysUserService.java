package com.example.ems.Service;

import com.example.ems.Entity.sysuser;
import com.example.ems.Exception.paramException;
import com.example.ems.Utils.BeanValidator;
import com.example.ems.mapper.SysuserMapper;
import com.example.ems.param.UserParam;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Repository
@Service
public class SysUserService {
    @Resource
    private SysuserMapper sysuserMapper;
    ModelMap map ;
    public void registry(UserParam param) {
        BeanValidator.check(param);
        if (checkExist(param.getUsername(), param.getTelephone(), param.getMail(), param.getAcount())) {
            map.addAttribute("msg","该用户已存在");
            throw new paramException("该用户已存在");
        }
        sysuser user = sysuser.builder().username(param.getUsername()).telephone(param.getTelephone()).mail(param.getMail()).acount(param.getAcount()).password(MD5Ped(param.getPassword())).remark(param.getRemark()).deptId(param.getDeptid()).status(param.getStatus()).roleId(param.getRoleid()).rolename(param.getRolename()).build();
        user.setOperator("system");
        user.setOperateIp("127.0.0.1");
        user.setOperateTime(new Date());
        user.setStatus(1);
        user.setRolename(judgerole(param.getRoleid()));
        sysuserMapper.insertSelective(user);
    }

    public static String MD5Ped(String password) {
        //加密算法MD5
        //salt盐
        String md5Pwd = new SimpleHash("MD5", password).toHex();
        return md5Pwd;
    }

    private boolean checkExist(String username, String telephone, String mail, String acount) {
        return sysuserMapper.selectByparams(username, telephone, mail, acount).size() > 0;
    }

    private String judgerole(Integer roleid) {
        if (roleid == 1) {
            return "管理员";
        }else{
            return "员工";
        }
    }
}
