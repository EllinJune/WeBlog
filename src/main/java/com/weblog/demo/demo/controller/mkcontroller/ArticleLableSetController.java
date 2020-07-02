package com.weblog.demo.demo.controller.mkcontroller;

import com.weblog.demo.demo.service.mkservice.ArticleLableSetService;
import com.weblog.demo.demo.service.mkservice.CommentsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//该注解不支持页面跳转，所有方法执行完后，都会向前端返回字符串格式的数据
//如果返回的是集合或者对象，自动转换为json格式的数据
@RestController
public class ArticleLableSetController {

    @Resource
    private ArticleLableSetService artlabsetService;

    @RequestMapping("/findalllables")
    public List<Map<String,Object>> findAll() {
        List<Map<String,Object>> list=artlabsetService.findAll();
        return list;
    }

    /**
     * 通过RequestMapping设置该方法，请求的路径
     * @return
     */
    @RequestMapping("/findlabbyartid")
    public List<Map<String,Object>> findByArtid(@RequestParam int artid){
        List<Map<String,Object>> list=artlabsetService.findByArtid(artid);
        return list;
    }

    @RequestMapping("/findartbylabid")
    public List<Map<String,Object>> findByLabid(@RequestParam int labid){
        List<Map<String,Object>> list=artlabsetService.findByLabid(labid);
        return list;
    }

    /**
     *
     * RequestParam 就是通知服务器，前端提交的数据封装成Map集合
     *      以表单控件的name属性的值作为 map集合的key
     *      以表单控件的value属性的值作为map集合的value
     * @param map
     * @return
     */
    @RequestMapping("/saveartlabset")
    public String save(@RequestParam Map<String,String> map){
        String msg="增加失败";
        boolean flag=artlabsetService.doSave(map);
        if(flag){
            msg="增加成功";
        }
        return msg;
    }

    /**
     * url 只要符合java命名规范即可
     * @param map
     * @return
     */
    @RequestMapping("/deleteart")
    public String deleteArt(@RequestParam Map<String,String> map){
        System.out.println(map);
        String msg="删除失败";
        boolean flag=artlabsetService.doDeleteArt(map);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }

    @RequestMapping("/deletelab")
    public String deleteLab(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=artlabsetService.doDeleteLab(map);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }

    @RequestMapping("/editartlabset")
    public String update(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=artlabsetService.doUpdate(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }
}



