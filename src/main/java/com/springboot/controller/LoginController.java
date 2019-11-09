package com.springboot.controller;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.domain.User;
import com.springboot.service.admin.AdminLoginAuthService;
import com.springboot.service.doctor.DoctorLoginAuthService;
import com.springboot.service.user.UserLoginAuthService;
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

    @Autowired
    UserLoginAuthService userLoginAuthServiceImpl;

    @Autowired
    DoctorLoginAuthService doctorLoginAuthServiceImpl;

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type,
                            Map<String, Object> map,HttpSession session){
        System.out.println("Control");
        boolean flag = false;
        /** 根据角色判断账号密码是否正确 */
        if(type.equals("user")){
            User login = new User();
            login.setUSER_NAME(username);
            login.setUSER_PASSWORD(password);
            flag = userLoginAuthServiceImpl.userLoginAuth(login);
        }else if(type.equals("doctor")){
            Doctor login = new Doctor();
            login.setDOCTOR_NAME(username);
            login.setDOCTOR_PASSWORD(password);
            login.toString();
            flag = doctorLoginAuthServiceImpl.doctorLoginAuth(login);
        }else if(type.equals("admin")){
            Admin login = new Admin();
            login.setADMIN_NAME(username);
            login.setADMIN_PASSWORD(password);
            flag = adminLoginAuthServiceImpl.adminLoginAuth(login);
        }else{ }

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

    @GetMapping("/login2")
    public String login111(){
        return "login2";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }


}
