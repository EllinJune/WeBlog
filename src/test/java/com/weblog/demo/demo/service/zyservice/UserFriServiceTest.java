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
class UserFriServiceTest {
    @Resource
    private UserFriService userFriService;

    @Test
    void doSave() {
        Map<String,String> map=new HashMap<>();
        map.put("id","2");
        map.put("friendsid","3");
        map.put("note","你才是mdzz");
        map.put("status","1");
        userFriService.doSave(map);
    }

    @Test
    void doUpdateStatus() {
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        map.put("friendsid","2");
        map.put("status","0");
        userFriService.doUpdateStatus(map);
    }

    @Test
    void doUpdateNote() {
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        map.put("friendsid","2");
        map.put("note","hhhh");
        userFriService.doUpdateNote(map);
    }

    @Test
    void findFriByid() {
        Map<String,String> map=new HashMap<>();
        map.put("id","2");
        List<Map<String,Object>> friset=null;
        friset=userFriService.findFriByid(map);
        System.out.println(friset);
    }
}