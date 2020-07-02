package com.weblog.demo.demo.service.zyservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserInfoServiceTest {
    @Resource
    private UserInfoService userInfoService;
    @Test
    void doSave() {
        Map<String,String> map=new HashMap<>();
        map.put("name","王老师");
        map.put("pwd","121");
        map.put("profilephoto","zd");
        map.put("regtime","2018-9-9 18:00:00");
        map.put("birthday","2000-9-9");
        map.put("sex","男");
        map.put("age","22");
        map.put("right","0");
        userInfoService.doSave(map);
    }

    @Test
    void doDelete() {
        Map<String,String> map=new HashMap<>();
        map.put("id","5");
        userInfoService.doDelete(map);
    }

    @Test
    void doUpdate() {
        Map<String,String> map=new HashMap<>();
        map.put("id","2");
        map.put("name","李老师");
        map.put("pwd","111");
        map.put("profilephoto","zbd");
        map.put("regtime","2018-9-9 18:00:00");
        map.put("birthday","2000-9-9");
        map.put("sex","女");
        map.put("age","22");
        map.put("right","0");
        userInfoService.doUpdate(map);
    }

    @Test
    void findById() {
        Map<String,String> map=new HashMap<>();
        map.put("id","2");
        Map<String,Object> tea=userInfoService.findById(map);
        System.out.println(tea);
    }

    @Test
    void findByName() {
        Map<String,String> map=new HashMap<>();
        map.put("name","老师");
        Map<String,Object> userset=userInfoService.findByName(map);
        System.out.println(userset);
    }

    @Test
    void login() {
        Map<String,String> map=new HashMap<>();
        map.put("name","张老师");
        map.put("pwd","111");
        Map<String,String> n = userInfoService.Login(map);
        System.out.println(n);
    }
}