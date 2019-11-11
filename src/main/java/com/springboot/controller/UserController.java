package com.springboot.controller;

import com.springboot.domain.Reply;
import com.springboot.domain.ReportForm;
import com.springboot.service.doctor.DoctorLoginAuthService;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reply.ReplyGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.user.UserLoginAuthService;
import org.omg.CORBA.ObjectHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    ReportFormInsertService reportFormInsertServiceImpl;

    @Autowired
    OfficeGetService officeGetServiceImpl;
    @GetMapping("/toAskVisit")
    public String toAskVisit(Model model){
        System.out.println("ask");
        model.addAttribute("officeList",officeGetServiceImpl.getAllOffice());
        return "user/askVisit";
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

    @PostMapping("/uploadAsk")
    @ResponseBody
    public String uploadAsk(@RequestParam("title") String title, @RequestParam("content") String content,@RequestParam("office") String office, HttpServletRequest request,HttpSession session){
        System.out.println(title + " " + content);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        List<String> fileNames = new ArrayList<>();
        SimpleDateFormat ftName = new SimpleDateFormat ("MMddhhmmss");
        int random = (int)((Math.random() * 9 + 1) * 10);
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            /** 文件格式：时分秒+毫秒+两位随机数+序号+后缀名 */
            String fileNameTemp = ftName.format(new Date())+ random +i+suffixName;
            fileNames.add(fileNameTemp);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File("F:\\file\\study\\idea\\JavaWeb\\APER2019\\src\\main\\resources\\static\\img\\reporimgs\\"
                            +fileNameTemp)));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return e.getMessage();
                }
            } else {
                return "You failed to upload " + i + " because the file was empty.";
            }
        }
        String REPORTFORM_IMG = fileNames.get(0);
        for (int i = 1; i < files.size(); ++i) {
            REPORTFORM_IMG = REPORTFORM_IMG + ";" + fileNames.get(i);
        }
        System.out.println(REPORTFORM_IMG);
        reportFormInsertServiceImpl.insertReportForm(session.getAttribute("username").toString(),title,content,office,REPORTFORM_IMG);
        return "success";
    }


}
