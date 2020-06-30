package com.weblog.demo.demo.service.mkservice;

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
public class CommentsServiceTest {

    @Resource
    private CommentsService cmtService;

    @Test
    public void doSave() {
        Map<String,String> addcmt=new HashMap<>();
        addcmt.put("uid","1");
        addcmt.put("artid","1");
        addcmt.put("likecount","9");
        addcmt.put("date","2020-5-26");
        addcmt.put("content","我的评论");
        boolean flag=cmtService.doSave(addcmt);
        assertTrue(flag);
    }

    @Test
    public void doDelete() {
    }

    @Test
    public void doUpdate() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }
}