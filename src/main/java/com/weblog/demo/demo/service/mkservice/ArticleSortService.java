package com.weblog.demo.demo.service.mkservice;

import com.weblog.demo.demo.mapper.mkmapper.ArticleLableSetMapper;
import com.weblog.demo.demo.mapper.mkmapper.ArticleSortMapper;
import com.weblog.demo.demo.mapper.mkmapper.CommentsMapper;
import com.weblog.demo.demo.mapper.mkmapper.LablesMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//我们spring框架就知道，在BeanFactory中要管理该类
@Service
public class ArticleSortService {

    @Resource
    private ArticleSortMapper artsortMapper;

    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=artsortMapper.addLable(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    public boolean doDeleteLab(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("id"));
            artsortMapper.deleteLabSet(id);
            int r=artsortMapper.deleteLab(id);
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
            int r=artsortMapper.update(map);
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
            list=artsortMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据lable_id找到lable_name
    public Map<String,Object> findLabName(int labid){
        Map<String,Object> lable=null;
        try {
            lable=artsortMapper.findByLabid(labid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return lable;
    }
}

