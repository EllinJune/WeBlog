package com.weblog.demo.demo.service.mkservice;

import com.weblog.demo.demo.mapper.mkmapper.ArticleLableSetMapper;
import com.weblog.demo.demo.mapper.mkmapper.CommentsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

//我们spring框架就知道，在BeanFactory中要管理该类
@Service
public class ArticleLableSetService {

    @Resource
    private ArticleLableSetMapper artlabsetMapper;

    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=artlabsetMapper.addLabSet(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    public boolean doDeleteArt(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("artid"));
            int r=artlabsetMapper.deleteArt(id);
            if(r>0){
                flag=true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean doDeleteLab(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("labid"));
            int r=artlabsetMapper.deleteLab(id);
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
            int r=artlabsetMapper.update(map);
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
            list=artlabsetMapper.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据article_id找到所属的lab
    public List<Map<String,Object>> findByArtid(int artid){
        List<Map<String,Object>> artlabset=null;
        try {
            artlabset=artlabsetMapper.findByArtid(artid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return artlabset;
    }

    //根据lable_id找到其下的文章
    public List<Map<String,Object>> findByLabid(int labid){
        List<Map<String,Object>> artlabset=null;
        try {
            artlabset=artlabsetMapper.findByLabid(labid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return artlabset;
    }
}
