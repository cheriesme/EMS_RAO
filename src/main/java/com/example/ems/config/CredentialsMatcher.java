package com.example.ems.config;

import com.example.ems.Service.SysUserService;
import com.example.ems.mapper.SysuserMapper;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;


public class CredentialsMatcher extends SimpleCredentialsMatcher {
 @Autowired
 private SysUserService sysUserService;
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        String password = new String(usernamePasswordToken.getPassword());
        String md5password = sysUserService.MD5Ped(password);
        String dbpassword = (String) info.getCredentials();
        return this.equals(md5password,dbpassword);
    }
}
