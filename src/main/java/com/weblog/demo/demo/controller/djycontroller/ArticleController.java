package com.weblog.demo.demo.controller.djycontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.weblog.demo.demo.service.djyservice.ArticleService;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Resource
    private  ArticleService articleService;
    /**
     *
     * RequestParam 就是通知服务器，前端提交的数据封装成Map集合
     *      以表单控件的name属性的值作为 map集合的key
     *      以表单控件的value属性的值作为map集合的value
     * @param map
     * @return
     */
    @RequestMapping("/save")
    public String save(@RequestParam Map<String,String> map){
        String msg="保存失败";
        boolean flag=articleService.doSaveArticle(map);
        if(flag){
            msg="保存成功";
        }
        return msg;
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam int id)
    {
        String msg="删除失败";
        boolean flag=articleService.doDelete(id);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }
    @RequestMapping("/edit")
    public String update(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=articleService.doUpdate(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }
    @RequestMapping("/findbyid")
    public String findById(@RequestParam int id){
        String msg="修改失败";
        boolean flag=articleService.findById(id);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }
}
