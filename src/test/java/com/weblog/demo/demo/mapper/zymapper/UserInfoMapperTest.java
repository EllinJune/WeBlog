package com.weblog.demo.demo.mapper.zymapper;

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
class UserInfoMapperTest {
    @Resource
    private UserInfoMapper userInfoMapper;
    @Test
    void findAll() {
        List<Map<String,Object>> list=userInfoMapper.findAll();
        System.out.println(list);
    }

    @Test
    void save() {
        //使用map集合存放数据
        //#{user.id},#{user.name},#{user.pwd},#{user.profilephoto}," +
        //            "#{user.regtime},#{user.birthday},#{user.sex},#{user.age}," +
        //            "#{user.right}
        Map<String,String> map=new HashMap<>();
        map.put("name","王老师");
        map.put("pwd","121");
        map.put("profilephoto","zd");
        map.put("regtime","2018-9-9 18:00:00");
        map.put("birthday","2000-9-9");
        map.put("sex","男");
        map.put("age","22");
        map.put("right","0");
        int n=userInfoMapper.save(map);
        System.out.println(n);
    }

    @Test
    void findById() {
        Map<String,Object> map=userInfoMapper.findById(3);
        System.out.println(map);
    }

    @Test
    void findByName() {
        Map<String,Object> list=userInfoMapper.findByName("张老师");
        System.out.println(list);
    }

    @Test
    void delete() {
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        int n=userInfoMapper.delete(10);
    }

    @Test
    void update() {
        Map<String,String> map=new HashMap<>();
        map.put("id","3");
        map.put("name","王老师");
        map.put("pwd","111");
        map.put("profilephoto","zbd");
        map.put("regtime","2018-9-9 18:00:00");
        map.put("birthday","2000-9-9");
        map.put("sex","女");
        map.put("age","22");
        map.put("right","0");
        int n=userInfoMapper.update(map);
        System.out.println(n);
    }

    @Test
    void login() {
        Map<String,String> map=new HashMap<>();
        map.put("name","张老师");
        map.put("pwd","111");
        Map<String,Object> n = userInfoMapper.Login(map);
        System.out.println(n);
    }

    @Test
    void updatecode() {
        Map<String,String> map=new HashMap<>();
        map.put("name","zy");
        map.put("pwd","111");
        int n=userInfoMapper.updatecode(map);
        System.out.println(n);
    }
}