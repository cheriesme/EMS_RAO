package com.example.ems.config;

import com.example.ems.Entity.sysuser;
import com.example.ems.Service.SysUserService;
import com.example.ems.mapper.SysuserMapper;
import org.apache.catalina.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jdk.internal.org.objectweb.asm.Type.getType;

/**
 * @Auther raoyanping
 * @Date 2020/3/30 17:13
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Resource
    private SysuserMapper sysuserMapper;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        sysuser user = (sysuser)principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> acountset = new HashSet<>();
        acountset.add(user.getAcount());
        info.setStringPermissions(acountset);
        return info;
    }
    /**
     * 注入userservice获取用户认证信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException{
        System.out.println("----身份认证----");
//        String acount = (String) authenticationToken.getPrincipal();
//        String password = new String((char[])authenticationToken.getCredentials());
//        String inputPassword = sysUserService.MD5Ped(password);
//        sysuser user = sysuserMapper.selectByAcount(acount);
//        String md5password = user.getPassword();
//        System.out.println(inputPassword);
//        System.out.println(md5password);
//        if (acount == null){
//            throw new AccountException("用户名不正确");
//        }else if(!inputPassword.equals(md5password)){
//            throw new AccountException("realm密码不正确");
//        }
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String acount = usernamePasswordToken.getUsername();
        sysuser user = sysuserMapper.selectByAcount(acount);
        return new SimpleAuthenticationInfo(acount,user.getPassword(),this.getClass().getName());
    }
}
