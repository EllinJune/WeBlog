package com.weblog.demo.demo.mapper.zymapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserFriMapperTest {
    @Resource
    private UserFriMapper userFriMapper;
    @Test
    void findFriByid() {
    }

    @Test
    void save() {
        //user_id,user_friends_id,user_note,user_status
        Map<String,String> map=new HashMap<>();
        map.put("id","2");
        map.put("friendsid","1");
        map.put("note","你才是mdzz");
        map.put("status","1");

        int n=userFriMapper.save(map);
        System.out.println(n);
    }

    @Test
    void delete() {
        int n=userFriMapper.delete(2,3);
        System.out.println(n);

    }

    @Test
    void updatenote() {
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        map.put("friendsid","2");
        map.put("note","nmslzd");
        int n=userFriMapper.updatenote(map);
        System.out.println(n);
    }

    @Test
    void updatestatus() {
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        map.put("friendsid","2");
        map.put("status","1");
        int n=userFriMapper.updatestatus(map);
        System.out.println(n);
    }
}