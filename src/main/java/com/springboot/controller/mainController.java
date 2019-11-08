package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController {

    @GetMapping("/admin/main")
    public String goToAPages(String acw_sc__v2, Model model){
        //System.out.println(acw_sc__v2);
        model.addAttribute("acw_sc__v2",acw_sc__v2);
        return "main";
    }
}
