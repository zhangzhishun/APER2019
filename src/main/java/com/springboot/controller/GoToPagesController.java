package com.springboot.controller;

import com.springboot.domain.CSDN;
import com.springboot.service.CopyFromCsdnService;
import com.springboot.service.SelectAllBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

@Controller
public class GoToPagesController {
    @Autowired
    SelectAllBlogService selectAllBlogServiceImpl;

    @Autowired
    CopyFromCsdnService copyFromCsdnServiceImpl;

    @PostMapping("/admin/GoToPages")
    public String goToPages(@RequestParam("acw_sc__v2") String acw_sc__v2,@RequestParam("pages") String pages,Model model){
        copyFromCsdnServiceImpl.setAcw_sc__v2(acw_sc__v2);
        List<CSDN> csdnListResult = copyFromCsdnServiceImpl.FindAllArticle(pages);
        //System.out.println(csdnListResult);
        model.addAttribute("csdnListResult",csdnListResult);
        return "csdnList";
    }

/*    @GetMapping("/admin/GoToPages")
    public String goToPages(Model model){
        List<CSDN> csdnList = copyFromCsdnService.FindAllArticle("1");
        model.addAttribute("csdnResult",csdnList);
        *//*List<Map<String, Object>> csdnInMysql = csdnDao.SelectContent();
        System.out.println(csdnInMysql);*//*
        return "GoToPages";
    }*/

    @GetMapping("/admin/insert/{id}")
    public String goToAPages(@PathVariable("id") String id, Model model){
        List<CSDN> csdnListResult = copyFromCsdnServiceImpl.getCsdnResult();
        CSDN temp = csdnListResult.get(Integer.valueOf(id));
        System.out.println(csdnListResult.get(Integer.valueOf(id)).getArticle_title());
        System.out.println(csdnListResult.get(Integer.valueOf(id)).getArticle_content());
        /* 返回1位插入成功！ */
        Integer re = selectAllBlogServiceImpl.InsertContent(temp);
        //System.out.println(re);
        model.addAttribute("insertResult",re);
        return "insertResult";
    }


    @GetMapping("/admin/GoToPages")
    public String goToAPages1(Model model){
        List<CSDN> csdnListResult = copyFromCsdnServiceImpl.FindAllArticle("1");
        //System.out.println(csdnListResult);
        model.addAttribute("csdnListResult",csdnListResult);
        return "csdnList";
    }

    @GetMapping("/admin/success")
    @ResponseBody
    public List<CSDN> success(Model model){
        CSDN csdn1 = new CSDN("title1");
        CSDN csdn2 = new CSDN("title2");
        CSDN csdn3 = new CSDN("title3");
        List<CSDN> csdnList = new ArrayList<>();
        csdnList.add(csdn1);
        csdnList.add(csdn2);
        csdnList.add(csdn3);
        return csdnList;
    }
}
