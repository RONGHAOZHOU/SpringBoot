package com.ronghao.chapter11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 11:19 PM 3/14/2018
 * ==============================
 **********************************/
@Controller
public class UploadController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    private void executeUpload(String uploadDir,MultipartFile file) throws Exception{
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filename= UUID.randomUUID()+suffix;
        File serverFile = new File(uploadDir + filename);
        file.transferTo(serverFile);
    }

    @RequestMapping(value ="/upload",method =RequestMethod.POST)
    public @ResponseBody String upload(HttpServletRequest request ,MultipartFile file){
        try {
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            executeUpload(uploadDir,file);
        } catch (Exception e) {
            e.printStackTrace();
            return "upload failed";
        }
        return "上传成功！";
    }

    @RequestMapping(value ="/uploads",method =RequestMethod.POST)
    public @ResponseBody String uploads(HttpServletRequest request ,MultipartFile[] file){
        try {
            String uploadDir=request.getSession().getServletContext().getRealPath("/")+"upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "uploads failed";
        }
        return "上传成功！";
    }



}
