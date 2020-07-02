package com.weblog.demo.demo.mapper.mkmapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class LablesMapperTest {

    @Resource
    private LablesMapper lablemapper;
    @Test
    void findAll() {
        List<Map<String,Object>> map=lablemapper.findAll();
        System.out.println(map);
    }

    @Test
    void addLable() {
        Map<String,String> addlab=new HashMap<>();
        addlab.put("id","10");
        addlab.put("name","有点喜欢有点不喜欢的");
        int n=lablemapper.addLable(addlab);
        assertEquals(1,n);
    }

    @Test
    void update() {
        Map<String,String> addlab=new HashMap<>();
        addlab.put("id","1");
        addlab.put("name","改一下");
        int n=lablemapper.update(addlab);
        assertEquals(1,n);
    }

    @Test
    void findByLabid() {
        Map<String,Object> map=lablemapper.findByLabid(1);
        System.out.println(map);
    }

    @Test
    void deleteLab() {
        int n = lablemapper.deleteLab(1);
        //assertEquals(1,n);
    }
}