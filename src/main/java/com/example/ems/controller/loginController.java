package com.example.ems.controller;

import com.example.ems.Entity.sysuser;
import com.example.ems.mapper.SysuserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class loginController {
@Resource
    private SysuserMapper sysuserMapper;
@PostMapping("/login.page")
    public String login(@RequestParam("acount") String acount, @RequestParam("password") String password, HttpSession session){
    //从SecurityUtil里面创建一个subject
    System.out.println(acount+password);
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken token = new UsernamePasswordToken(acount, password);
//    subject.login(token);
    try {
        subject.login(token);
    }catch (UnknownAccountException uae){
        return "未知账户";
    }catch (IncorrectCredentialsException ice){
        return"controller密码不正确";
    }catch (LockedAccountException lae){
        return "账户已锁定";
    }catch (ExcessiveAttemptsException eae){
        return"用户名或密码错误次数太多";
    }catch (AuthenticationException ae){
        return "用户名或密码不正确";
    }
    subject.login(token);
    if (subject.isAuthenticated()){
        sysuser user = sysuserMapper.selectByAcount(acount);
        session.setAttribute("name",user.getUsername());
        return "index_main";
    }else {
        return "index";
    }
}

}
