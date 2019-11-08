package com.springboot.controller;

import com.springboot.utils.copyFromCsdn.GetAcw_sc__v2;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class GetAcwController {

    @GetMapping(value = "/admin/getAcw")
    public String login(HttpServletResponse response){
        GetAcw_sc__v2 getAcw_sc__v2 = new GetAcw_sc__v2();
        String acw_sc__v2 = getAcw_sc__v2.getAcw_sc__v2();
        /*Cookie cookie = new Cookie("acw_sc__v2", acw_sc__v2);
        cookie.setPath("/");// 这个要设置
        // cookie.setDomain(".aotori.com");//这样设置，能实现两个网站共用
        cookie.setMaxAge(365 * 24 * 60 * 60);// 不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
        response.addCookie(cookie);         //添加第一个Cookie*/
        //System.out.println(acw_sc__v2);
        return "redirect:/admin/main?acw_sc__v2="+acw_sc__v2;
    }
}
