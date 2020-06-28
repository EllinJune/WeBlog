package com.weblog.demo.demo.service.zyservice;

import com.weblog.demo.demo.mapper.zymapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=userInfoMapper.save(map);
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
            int r=userInfoMapper.delete(id);
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
            int r=userInfoMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
    public Map<String,Object> findById(Map<String,String> map){
        Map<String,Object> tea=null;
        try {
            int id=Integer.parseInt(map.get("id"));
            tea=userInfoMapper.findById(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return tea;
    }
    public List<Map<String,Object>> findByName(Map<String,String> map){
        List<Map<String,Object>> userset=null;
        try {
            String name=map.get("name");
            userset = userInfoMapper.findByName(name);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return userset;
    }
}
