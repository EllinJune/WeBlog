package com.weblog.demo.demo.service.zyservice;

import com.weblog.demo.demo.mapper.zymapper.UserFriMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserFriService {
    @Resource
    private UserFriMapper userFriMapper;

    /**
     * 添加好友
     * @param map
     * @return boolean
     */
    public boolean doSave(Map<String,String> map){
        boolean flag=false;
        //选择要添加监控的代码
        //ctrl+alt+t 打开 surround with窗口 选择 try catch
        try {
            int r=userFriMapper.save(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //记录日志，写到文件中进行保存
        }
        return flag;
    }

    /**
     * 删除或恢复好友
     * @param map
     * @return boolean
     */
    public boolean doUpdateStatus(Map<String,String> map){
        boolean flag=false;
        try {

            int r=userFriMapper.updatestatus(map);
            if(r>0){
                flag=true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 更改备注
     * @param map
     * @return boolean
     */
    public boolean doUpdateNote(Map<String,String> map){
        boolean flag=false;
        try {
            int r=userFriMapper.updatenote(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 通过id查询所有好友
     * @param map
     * @return boolean
     */
    public  List<Map<String,Object>> findFriByid(Map<String,String> map){
        List<Map<String,Object>> friset=null;
        try {
            int id=Integer.parseInt(map.get("id"));
            friset=userFriMapper.findFriByid(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return friset;
    }
//    public List<Map<String,Object>> findByName(Map<String,String> map){
//        List<Map<String,Object>> userset=null;
//        try {
//            String name=map.get("name");
//            userset = userFriMapper.findByName(name);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        return userset;
//    }
}
