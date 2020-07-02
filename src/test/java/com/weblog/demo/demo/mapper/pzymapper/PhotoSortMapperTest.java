package com.weblog.demo.demo.mapper.pzymapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PhotoSortMapperTest {

    @Resource
    private PhotoSortMapper photoSortMapper;

    @Test
    public void save() {
        Map<String,String> map=new HashMap<>();
        map.put("name","test");
        map.put("userId","1");
        int n=photoSortMapper.save(map);
        assertEquals(1,n);

    }

    @Test
    public void update() {
        Map<String,String> map=new HashMap<>();
        map.put("name","test");
        map.put("id","1");
        int n=photoSortMapper.update(map);
        assertEquals(1,n);
    }

    @Test
    public void delete() {
        int n=photoSortMapper.delete(3);
        assertEquals(1,n);
    }


    @Test
    public void findByUserId() {
        List<Map<String,Object>> list=photoSortMapper.findByUserId(1);
        System.out.println(list);
    }
}