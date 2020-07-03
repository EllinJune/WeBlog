package com.weblog.demo.demo.controller.djycontroller;

import org.apache.ibatis.annotations.Param;
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
    @RequestMapping("/savearticle")
    public String savearticle(@RequestParam Map<String,String> map){
        String msg="发布失败";
        boolean flag=articleService.doSaveArticle(map);
        if(flag){
            msg="发布成功";
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
    @RequestMapping("/savecomment")
    public String savecomment(@RequestParam Map<String,String> map){
        String msg="发布失败";
        boolean flag=articleService.doSaveComment(map);
        if(flag){
            msg="发布成功";
        }
        return msg;
    }
    @RequestMapping("/all")
    public List<Map<String,Object>> message(){
        List<Map<String,Object>> list=articleService.doMessage();
        return list;
    }
    @RequestMapping("/find")
    public List<Map<String,Object>> findComment(){
        List<Map<String,Object>> list=articleService.doFindComment();
        return list;
    }
    @RequestMapping("/findwriter")
    public List<Map<String,Object>> findWriter(){
        List<Map<String,Object>> list=articleService.doFindWriter();
        return list;
    }
    @RequestMapping("/findobserver")
    public List<Map<String,Object>> findObserver(){
        List<Map<String,Object>> list=articleService.doFindObserver();
        return list;
    }
    @RequestMapping("/savesort")
    public String saveSort(@RequestParam Map<String,String> map){
        String msg="发布失败";
        boolean flag=articleService.doSaveSort(map);
        if(flag){
            msg="发布成功";
        }
        return msg;
    }
    @RequestMapping("/findArticleId")
    public Map<String,Object> findId(@RequestParam String t){
        Map<String,Object> list=articleService.doFindId(t);
        return list;
    }

    @RequestMapping("/findUserInfo")
    public Map<String,Object> findUserInfo(@RequestParam String name){
        Map<String,Object> map=articleService.doFindUserInfo(name);
        return map;
    }
}
