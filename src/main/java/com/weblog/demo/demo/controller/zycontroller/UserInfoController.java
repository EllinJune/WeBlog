package com.weblog.demo.demo.controller.zycontroller;

import com.weblog.demo.demo.service.zyservice.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 通过id，查找用户信息
     * @param map
     * @return user
     */
    @RequestMapping("/userinfo")
    public Map<String,Object> findById(@RequestParam Map<String,String> map){
        Map<String,Object> user = userInfoService.findById(map);
        return user;
    }

    /**
     * 用户注册，返回注册信息
     * 若存在同名用户，则返回失败信息
     * @param map
     * @return
     */
    @RequestMapping("/userreg")
    public String reg(@RequestParam Map<String,String> map){
        String msg="注册失败";
        Map<String,Object> user =userInfoService.findByName(map);
        if(user==null) {
            boolean flag = userInfoService.doSave(map);
            if (flag) {
                msg = "注册成功";
            }
        }
        return msg;
    }

    /**
     * 通过id，删除用户
     * @param map
     * @return String
     */
    @RequestMapping("/deleteuser")
    public String delete(@RequestParam Map<String,String> map){
        String msg="删除失败";
        boolean flag=userInfoService.doDelete(map);
        if(flag){
            msg="删除成功";
        }
        return msg;
    }

    /**
     * 通过id修改用户信息
     * @param map
     * @return String
     *
     */
    @RequestMapping("/edituser")
    public String update(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=userInfoService.doUpdate(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }


    @RequestMapping("/editpwd")
    public String updateCode(@RequestParam Map<String,String> map){
        String msg="修改失败";
        boolean flag=userInfoService.doUpdateCode(map);
        if(flag){
            msg="修改成功";
        }
        return msg;
    }

    /**
     * 通过名称返回map
     * @param map
     * @return map
     */
    @RequestMapping("/searchuser")
    public Map<String,Object> searchuser(@RequestParam Map<String,String> map){
        Map<String,Object> user =userInfoService.findByName(map);
        return user;
    }

    @RequestMapping("/login")
    public Map<String,String> login(@RequestParam Map<String,String> map){
        Map<String,String> msg = userInfoService.Login(map);
        return msg;
    }
}
