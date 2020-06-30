package com.weblog.demo.demo.controller.zycontroller;

import com.weblog.demo.demo.service.zyservice.UserFriService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserFriController {
    @Resource
    private UserFriService userFriService;

    /**
     * 添加好友关系，如果有了就返回失败
     * @param map
     * @return
     */
    @RequestMapping("/addfriend")
    public String addFriend(@RequestParam Map<String,String> map){
        String msg="添加失败";
        List<Map<String,Object>> friendset =userFriService.findFriByid(map);
        for (Map<String,Object> friend : friendset){
            int a=Integer.parseInt(map.get("friendsid"));
            if (Integer.parseInt(String.valueOf(friend.get("user_friends_id")))==a){
                return msg;
            }
        }
            boolean flag = userFriService.doSave(map);
            if (flag) {
                msg = "添加成功";
            }
        return msg;
    }

    /**
     * 返回id对应的所有好友关系记录
     * @param map
     * @return
     */
    @RequestMapping("/allfriends")
    public List<Map<String,Object>> allFriends(@RequestParam Map<String,String> map){
        List<Map<String,Object>> friends =userFriService.findFriByid(map);
        return friends;
    }

    /**
     * 修改备注
     * @param map
     * @return
     */
    @RequestMapping("/editnote")
    public String upDateNote(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=userFriService.doUpdateNote(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }

    /**
     * 修改status，即删除好友或恢复
     * @param map
     * @return
     */
    @RequestMapping("/editstatus")
    public String upDateStatus(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=userFriService.doUpdateStatus(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }
}
