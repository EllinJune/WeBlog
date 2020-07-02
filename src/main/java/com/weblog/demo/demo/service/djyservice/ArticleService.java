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
    public boolean doSaveComment(Map<String,String> map){
        boolean flag=false;
        try {
            int r= articleMapper.saveComment(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }
    public List<Map<String,Object>>  doMessage(){
        List<Map<String,Object>> list=null;
        try {
             list= articleMapper.message();

        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
    public List<Map<String,Object>>  doFindComment(){
        List<Map<String,Object>> list=null;
        try {
            list= articleMapper.findcomment();

        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
    public List<Map<String,Object>>  doFindWriter(){
        List<Map<String,Object>> list=null;
        try {
            list= articleMapper.findwriter();

        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
    public List<Map<String,Object>>  doFindObserver(){
        List<Map<String,Object>> list=null;
        try {
            list= articleMapper.findobserver();

        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
    public List<Map<String,Object>>  doFindId(String title){
        List<Map<String,Object>> list=null;
        try {
            list= articleMapper.findId(title);

        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return list;
    }
    public boolean doSaveSort(Map<String,String> map){
        boolean flag=false;
        try {
            int r= articleMapper.saveSort(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }
}
