package com.weblog.demo.demo.controller.djycontroller;

import com.weblog.demo.demo.service.djyservice.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {
    @Resource
    private AdminService adminService;
    @RequestMapping("/deleteArticles")
    public String deleteArticles(@RequestParam int id)
    {
        String msg="删除失败";
        boolean flag=adminService.doDeleteArticles(id);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }
    @RequestMapping("/deletePhotos")
    public String deletePhotos(@RequestParam int id)
    {
        String msg="删除失败";
        boolean flag=adminService.doDeletePhotos(id);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }
    @RequestMapping("/deleteComments")
    public String deleteComments(@RequestParam int id)
    {
        String msg="删除失败";
        boolean flag=adminService.doDeleteComments(id);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }
    @RequestMapping("/aInfo")
    public List<Map<String,Object>> articleInfo(){
        List<Map<String,Object>> list=adminService.doArticleInfo();
        return list;
    }
    @RequestMapping("/pInfo")
    public List<Map<String,Object>> photoInfo(){
        List<Map<String,Object>> list=adminService.doPhotoInfo();
        return list;
    }
    @RequestMapping("/cInfo")
    public List<Map<String,Object>> commentInfo(){
        List<Map<String,Object>> list=adminService.doCommentInfo();
        return list;
    }
}
