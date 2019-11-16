package com.springboot.controller;

import com.springboot.domain.User;
import com.springboot.service.doctor.DoctorDeleteService;
import com.springboot.service.doctor.DoctorGetService;
import com.springboot.service.user.UserDeleteService;
import com.springboot.service.user.UserGetService;
import com.springboot.service.user.UserRegisterService;
import com.springboot.service.user.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserGetService userGetServiceImpl;

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/main.html")
    public String mainHtml(){
        return "admin/main";
    }

    @GetMapping("/getAllUser")
    public String getAllUser(Model model){
        List<Map<String, Object>> user = userGetServiceImpl.getUser();
        model.addAttribute("user",user);
        return "admin/user/getAllUser";
    }

    @GetMapping("/updateUser/{USER_ID}")
    public String updateUserGet(@PathVariable("USER_ID") String USER_ID, Model model){
        Map<String,Object> user = userGetServiceImpl.getUserByUSERID(USER_ID);
        model.addAttribute("user",user);
        System.out.println(user);
        return "admin/user/updateUser";
    }

    @GetMapping("/addUserPage")
    public String addUserPage(){
        return "admin/user/addUser";
    }

    @Autowired
    UserRegisterService userRegisterServiceImpl;
    @PostMapping("/addUserPost")
    @ResponseBody
    public String addUserPost(@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                              @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,
                              @RequestParam("USER_WECHAT") String USER_WECHAT,Model model){
        User addUser = new User();
        addUser.setUSER_NAME(USER_NAME);
        addUser.setUSER_PHONE(USER_PHONE);
        addUser.setUSER_SEX(USER_SEX);
        addUser.setUSER_REALNAME(USER_REALNAME);
        addUser.setUSER_WECHAT(USER_WECHAT);
        addUser.setUSER_PASSWORD(USER_PASSWORD);
        return String.valueOf(userRegisterServiceImpl.userRegister(addUser));
    }


    @Autowired
    UserDeleteService userDeleteServiceImpl;
    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam("USER_ID") String USER_ID){
        return String.valueOf(userDeleteServiceImpl.userDelete(Integer.valueOf(USER_ID)));
    }


    @Autowired
    UserUpdateService userUpdateServiceImpl;
    @PostMapping("/updateUser")
    @ResponseBody
    public String updateUserPost(@RequestParam("USER_ID") String USER_ID,@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                                 @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,@RequestParam("USER_WECHAT") String USER_WECHAT){
        User newUser = new User();
        newUser.setUSER_NAME(USER_NAME);
        newUser.setUSER_PHONE(USER_PHONE);
        newUser.setUSER_SEX(USER_SEX);
        newUser.setUSER_REALNAME(USER_REALNAME);
        newUser.setUSER_WECHAT(USER_WECHAT);
        newUser.setUSER_PASSWORD(USER_PASSWORD);
        newUser.setUSER_ID(Integer.valueOf(USER_ID));
        return String.valueOf(userUpdateServiceImpl.userUpdate(newUser));
    }


    @Autowired
    DoctorGetService doctorGetServiceImpl;
    @GetMapping("/getAllDoctor")
    public String getAllDoctor(Model model){
        List<Map<String, Object>> doctor = doctorGetServiceImpl.getAllDoctor();
        model.addAttribute("doctor",doctor);
        return "admin/doctor/getAllDoctor";
    }

    @GetMapping("/updateDoctor/{DOCTOR_ID}")
    public String updateDoctor(@PathVariable("DOCTOR_ID") String USER_ID, Model model){
        Map<String,Object> user = userGetServiceImpl.getUserByUSERID(USER_ID);
        model.addAttribute("user",user);
        System.out.println(user);
        return "admin/doctor/updateDoctor";
    }

    @GetMapping("/addDoctorPage")
    public String addDoctorPage(){
        return "admin/doctor/addDoctor";
    }


    @PostMapping("/addDoctorPost")
    @ResponseBody
    public String addDoctorPost(@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                              @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,
                              @RequestParam("USER_WECHAT") String USER_WECHAT,Model model){
        User addUser = new User();
        addUser.setUSER_NAME(USER_NAME);
        addUser.setUSER_PHONE(USER_PHONE);
        addUser.setUSER_SEX(USER_SEX);
        addUser.setUSER_REALNAME(USER_REALNAME);
        addUser.setUSER_WECHAT(USER_WECHAT);
        addUser.setUSER_PASSWORD(USER_PASSWORD);
        return String.valueOf(userRegisterServiceImpl.userRegister(addUser));
    }

    @Autowired
    DoctorDeleteService doctorDeleteServiceImpl;
    @PostMapping("/deleteDoctor")
    @ResponseBody
    public String deleteDoctor(@RequestParam("DOCTOR_ID") String DOCTOR_ID){
        return String.valueOf(doctorDeleteServiceImpl.doctorDelete(Integer.valueOf(DOCTOR_ID)));
    }


    @PostMapping("/updateDoctor")
    @ResponseBody
    public String updateDoctor(@RequestParam("USER_ID") String USER_ID,@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                                 @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,@RequestParam("USER_WECHAT") String USER_WECHAT){
        User newUser = new User();
        newUser.setUSER_NAME(USER_NAME);
        newUser.setUSER_PHONE(USER_PHONE);
        newUser.setUSER_SEX(USER_SEX);
        newUser.setUSER_REALNAME(USER_REALNAME);
        newUser.setUSER_WECHAT(USER_WECHAT);
        newUser.setUSER_PASSWORD(USER_PASSWORD);
        newUser.setUSER_ID(Integer.valueOf(USER_ID));
        return String.valueOf(userUpdateServiceImpl.userUpdate(newUser));
    }



    @GetMapping("/getAllAdmin")
    public String getAllAdmin(Model model){
        List<Map<String, Object>> user = userGetServiceImpl.getUser();
        model.addAttribute("user",user);
        return "admin/admin/getAllAdmin";
    }

    @GetMapping("/updateAdmin/{ADMIN_ID}")
    public String updateAdmin(@PathVariable("USER_ID") String USER_ID, Model model){
        Map<String,Object> user = userGetServiceImpl.getUserByUSERID(USER_ID);
        model.addAttribute("user",user);
        System.out.println(user);
        return "admin/admin/updateAdmin";
    }

    @GetMapping("/addAdminPage")
    public String addAdminPage(){
        return "admin/admin/addAdmin";
    }

    @PostMapping("/addAdminPost")
    @ResponseBody
    public String addAdminPost(@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                              @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,
                              @RequestParam("USER_WECHAT") String USER_WECHAT,Model model){
        User addUser = new User();
        addUser.setUSER_NAME(USER_NAME);
        addUser.setUSER_PHONE(USER_PHONE);
        addUser.setUSER_SEX(USER_SEX);
        addUser.setUSER_REALNAME(USER_REALNAME);
        addUser.setUSER_WECHAT(USER_WECHAT);
        addUser.setUSER_PASSWORD(USER_PASSWORD);
        return String.valueOf(userRegisterServiceImpl.userRegister(addUser));
    }


    @PostMapping("/deleteAdmin")
    @ResponseBody
    public String deleteAdmin(@RequestParam("USER_ID") String USER_ID){
        return String.valueOf(userDeleteServiceImpl.userDelete(Integer.valueOf(USER_ID)));
    }


    @PostMapping("/updateAdmin")
    @ResponseBody
    public String updateAdminPost(@RequestParam("USER_ID") String USER_ID,@RequestParam("USER_NAME") String USER_NAME,@RequestParam("USER_PASSWORD") String USER_PASSWORD,
                                 @RequestParam("USER_PHONE") String USER_PHONE,@RequestParam("USER_SEX") String USER_SEX,@RequestParam("USER_REALNAME") String USER_REALNAME,@RequestParam("USER_WECHAT") String USER_WECHAT){
        User newUser = new User();
        newUser.setUSER_NAME(USER_NAME);
        newUser.setUSER_PHONE(USER_PHONE);
        newUser.setUSER_SEX(USER_SEX);
        newUser.setUSER_REALNAME(USER_REALNAME);
        newUser.setUSER_WECHAT(USER_WECHAT);
        newUser.setUSER_PASSWORD(USER_PASSWORD);
        newUser.setUSER_ID(Integer.valueOf(USER_ID));
        return String.valueOf(userUpdateServiceImpl.userUpdate(newUser));
    }


}
