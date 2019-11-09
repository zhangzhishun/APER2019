package com.springboot.controller;

import com.springboot.domain.Admin;
import com.springboot.service.admin.AdminLoginAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminLoginAuthService adminLoginAuthServiceImpl;

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type,
                            Map<String, Object> map,HttpSession session){
        boolean flag = false;
        if(type.equals("admin")){
            System.out.println("Control");
            Admin login = new Admin(username,password);
            flag = adminLoginAuthServiceImpl.adminLoginAuth(login);
        }

        if(flag){
            //登陆成功，防止表单重复提交，可以重定向到主页
            //System.out.println(username+" "+password +" "+type +":::::"+type + "/main");
            session.setAttribute("loginUser",username);
            return type + "/main";
        }else{
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }


}
