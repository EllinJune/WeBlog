package com.weblog.demo.demo.service.djyservice;

import com.weblog.demo.demo.mapper.djymapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    public boolean doSaveArticle(Map<String,String> map){
        boolean flag=false;
        try {
            int r= articleMapper.saveArticle(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    public boolean doDelete(int id){
        boolean flag=false;
        try {
            int r=articleMapper.delete(id);
            if(r>0){
                flag=true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public boolean doUpdate (Map<String,String> map)
    {
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=articleMapper.updateArticle(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }
    public boolean findById(int id){
        boolean flag=false;
        try {
            //flag=articleMapper.findById(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
