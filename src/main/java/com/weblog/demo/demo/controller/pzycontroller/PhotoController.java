package com.weblog.demo.demo.controller.pzycontroller;

import com.weblog.demo.demo.service.pzyservice.PhotoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class PhotoController {
    @Resource
    private PhotoService photoService;

    //创建相册、改相册名、删除相册、显示该相册下所有图片

    @RequestMapping("/createAlbum")
    public String createAlbum(@RequestParam Map<String,String> map)
    {
        String msg="创建相册失败";

        try {
            if(photoService.doCreateAlbum(map))
                msg="创建相册成功";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }

    @RequestMapping("/updateAlbum")
    public String updateAlbum(@RequestParam Map<String,String> map)
    {
        String msg="修改相册名失败";

        try {
            if(photoService.doUpdateAlbum(map))
                msg="修改相册名成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping("/deleteAlbum")
    public String deleteAlbum(@RequestParam Map<String,String> map)
    {
        String msg="删除相册失败";

        try {
            if(photoService.doUpdateAlbum(map))
                msg="删除相册成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping("/show")
    public String show(@RequestParam Map<String,String> map)
    {
        String msg="show失败";

        try {
            //if(photoService.findAllInAlbum(map))
                msg="show成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    //上传图片、删除图片
    @RequestMapping("/savePhoto")
    public String savePhoto(@RequestParam Map<String,String> map)
    {
        String msg="上传图片失败";

        try {
            if(photoService.doSave(map))
                msg="上传图片成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

    @RequestMapping("/deletePhoto")
    public String deletePhoto(@RequestParam Map<String,String> map)
    {
        String msg="删除图片失败";

        try {
            if(photoService.doDelete(map))
                msg="删除图片成功";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return msg;
    }

}
