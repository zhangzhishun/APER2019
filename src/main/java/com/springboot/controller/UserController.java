package com.springboot.controller;

import com.springboot.service.doctor.DoctorLoginAuthService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.user.UserLoginAuthService;
import org.omg.CORBA.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserLoginAuthService userLoginAuthServiceImpl;

    @Autowired
    ReplyGetService replyGetServiceImpl;

    @GetMapping("/main")
    public String userLogin(){
        //        session.setAttribute("loginUser",username);
        System.out.println("main");
        return "user/main";
    }

    /**
     * 返回具体的某一个医生的回复
     * */
    @GetMapping("/getREPLYID/{REPLY_ID}")
    public String getREPLYID(@PathVariable("REPLY_ID") String REPLY_ID, Model model){
        System.out.println(REPLY_ID);
        List<Map<String,Object>> result = replyGetServiceImpl.getReplyByREPLYID(REPLY_ID);
        List<String> imgs = new ArrayList<>();
        for (Map<String,Object>map:result
             ) {
            String[] getImgs = map.get("REPLY_IMG").toString().split(";");
            for (String s:getImgs
                 ) {
                imgs.add(s);
            }
        }
        model.addAttribute("userMsgImgs",imgs);
        model.addAttribute("userMsg",result);
        return "user/scanMsg";
    }


}
