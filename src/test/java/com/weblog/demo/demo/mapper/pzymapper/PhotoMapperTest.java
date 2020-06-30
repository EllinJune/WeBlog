package com.weblog.demo.demo.mapper.pzymapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PhotoMapperTest {

    @Resource
    private PhotoMapper photoMapper;
    @Test
    public void findById() {
        Map<String,Object> map=photoMapper.findById(2);
        System.out.println(map);
    }

    @Test
    public void save() {
        Map<String,String> map=new HashMap<>();
        map.put("userId","1");
        map.put("savePath","./img");
        int n=photoMapper.save(map);
        assertEquals(1,n);
    }

    @Test
    public void delete() {
        int n=photoMapper.delete(2);
        assertEquals(1,n);
    }
}