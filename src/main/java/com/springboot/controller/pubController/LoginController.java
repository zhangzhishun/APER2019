package com.springboot.controller.pubController;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import com.springboot.domain.User;
import com.springboot.service.admin.AdminLoginAuthService;
import com.springboot.service.doctor.DoctorLoginAuthService;
import com.springboot.service.property.PropertyGetService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.user.UserLoginAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminLoginAuthService adminLoginAuthServiceImpl;

    @Autowired
    UserLoginAuthService userLoginAuthServiceImpl;

    @Autowired
    DoctorLoginAuthService doctorLoginAuthServiceImpl;

    @Autowired
    ReplyGetService replyGetServiceImpl;

    @Autowired
    PropertyGetService propertyGetServiceImpl;

    @GetMapping("/userMain")
    public String userMainHtml(){
        return "user/main";
    }

    @GetMapping("/doctorMain")
    public String doctorMainHtml(){
        return "doctor/main";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type,
                            Map<String, Object> map,HttpSession session,Model model){
        System.out.println("Control");
        boolean flag = false;
        /** 根据角色判断账号密码是否正确 */
        if(type.equals("user")){
            User login = new User();
            login.setUSER_NAME(username);
            login.setUSER_PASSWORD(password);
            flag = userLoginAuthServiceImpl.userLoginAuth(login);
            if(flag){
                /** 如果登陆成功 */
                List<Map<String, Object>> userReply;
                userReply = replyGetServiceImpl.getReplyByUSERNAME(username);
                /** 统计有多少未读消息 */
                Integer unReadNumber = 0;
                for (Map<String, Object> re : userReply) {
                    if(re.get("REPLY_STATE").equals("0")){
                        unReadNumber++;
                    }
                }
                model.addAttribute("userMsg",userReply);
                model.addAttribute("fee",propertyGetServiceImpl.getPropertyByPROPERTYNAME("fee"));
                model.addAttribute("unReadNumber",String.valueOf(unReadNumber));
                session.setAttribute("username",username);
                return "redirect:userMain";
            }else{
                //登陆失败
                map.put("msg", "用户名密码错误");
                return "login";
            }
        }else if(type.equals("doctor")){
            Doctor login = new Doctor();
            login.setDOCTOR_NAME(username);
            login.setDOCTOR_PASSWORD(password);
            login.toString();
            flag = doctorLoginAuthServiceImpl.doctorLoginAuth(login);
            if(flag){
                session.setAttribute("loginUser",username);
                return "redirect:doctorMain";
            }else{
                //登陆失败
                map.put("msg", "用户名密码错误");
                return "login";
            }
        }else{ }

        //登陆失败
        map.put("msg", "用户名密码错误");
        return "login";
    }

}
