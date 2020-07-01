package com.weblog.demo.demo.mapper.mkmapper;

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
public class CommentsMapperTest {

    @Resource
    private CommentsMapper cmtMapper;
    @Test
    public void findAll() {
        List<Map<String,Object>> map=cmtMapper.findAll();
        System.out.println(map);
    }

    @Test
    public void findById() {
        List<Map<String,Object>> map=cmtMapper.findById(3);
        System.out.println(map);
    }

    @Test
    public void addCmt() {
        Map<String,String> addcmt=new HashMap<>();
        addcmt.put("uid","1");
        addcmt.put("artid","1");
        addcmt.put("likecount","9");
        addcmt.put("date","2020-5-26");
        addcmt.put("content","我的评论");
        int n=cmtMapper.addCmt(addcmt);
        assertEquals(1,n);
    }

    @Test
    public void update() {
        Map<String,String> cmt=new HashMap<>();
        cmt.put("id","3");
        cmt.put("uid","1");
        cmt.put("artid","1");
        cmt.put("likecount","10");
        cmt.put("date","2020-5-29");
        cmt.put("content","我的评论");
        int n=cmtMapper.update(cmt);
        assertEquals(1,n);
    }

    @Test
    public void delete() {
        int n = cmtMapper.delete(3);
        assertEquals(1,n);
    }
}