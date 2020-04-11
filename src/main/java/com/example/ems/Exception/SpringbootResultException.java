package com.example.ems.Exception;

import com.example.ems.common.Jsondata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class SpringbootResultException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest Request, HttpServletResponse Response, Object o, Exception e) {
        String url = Request.getRequestURI();
//        log.info(url);
        ModelAndView mv;
        String defaultMsg = "System error";
        //返回.json，.page
        if (url.endsWith(".json")){//请求数据时
            if (e instanceof PermissionException){
                Jsondata result = Jsondata.fail(e.getMessage());
                mv = new ModelAndView("jsonView_fail",result.toMap());
            }else{
                log.error("unknow json exception,url:" +url,e);
               Jsondata result = Jsondata.fail(defaultMsg);
               mv = new ModelAndView("jsonModel",result.toMap());
            }
        }else if(url.endsWith(".page")){//请求页面时

            log.error("unknow page exception,url:" +url,e);
            Jsondata result = Jsondata.fail(defaultMsg);
            mv = new ModelAndView("error404",result.toMap());
        }else {

            log.error("unknow exception,url:" +url,e);
            Jsondata result = Jsondata.fail(defaultMsg);
            mv = new ModelAndView("jsonModel",result.toMap());
        }
        return mv;
    }
}
