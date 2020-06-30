package com.weblog.demo.demo.service.mkservice;

import com.weblog.demo.demo.mapper.mkmapper.CommentsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//我们spring框架就知道，在BeanFactory中要管理该类
@Service
public class CommentsService {

    @Resource
    private CommentsMapper cmtMapper;

    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=cmtMapper.addCmt(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    public boolean doDelete(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("id"));
            int r=cmtMapper.delete(id);
            if(r>0){
                flag=true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean doUpdate(Map<String,String> map){
        boolean flag=false;
        try {
            int r=cmtMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Map<String,Object>> findAll(){
        List<Map<String,Object>> list=null;
        try {
            list=cmtMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据article_id找到某个文章下面的评论并返回List
    public List<Map<String,Object>> findById(int artid){
        List<Map<String,Object>> cmt=null;
        try {
            cmt=cmtMapper.findById(artid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return cmt;
    }
}
