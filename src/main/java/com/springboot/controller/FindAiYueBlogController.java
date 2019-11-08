package com.springboot.controller;

import com.springboot.domain.CSDN;
import com.springboot.service.SelectAllBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class FindAiYueBlogController {

    @Autowired
    SelectAllBlogService selectAllBlogServiceImpl;

    @GetMapping("/admin/FindAiYueBlog")
    public String get(Model model){
        List<Map<String, Object>> result;
        result = selectAllBlogServiceImpl.FindIdTitleAYBlog();
        model.addAttribute("aiYueBlog", result);
        /*for (Map<String, Object> r:result
             ) {
            model.addAttribute("aiYueBlog", r);
        }*/
        return "list";
    }
}
