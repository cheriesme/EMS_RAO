package com.example.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther raoyanping
 * @Date 2020/4/10 16:27
 */
@Controller
@RequestMapping("/main")
public class maincontrller {
    @RequestMapping("/main.page")
    public String main(){
        return "index_main";
    }
}

