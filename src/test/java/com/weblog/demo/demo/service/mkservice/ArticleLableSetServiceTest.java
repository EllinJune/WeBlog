package com.weblog.demo.demo.service.mkservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ArticleLableSetServiceTest {

    @Resource
    private ArticleLableSetService artlabsetService;

    @Test
    void doSave() {
        Map<String,String> addlabset=new HashMap<>();
        addlabset.put("artid","1");
        addlabset.put("labid","1");
        boolean flag=artlabsetService.doSave(addlabset);
        assertTrue(flag);
    }

    @Test
    void doDeleteArt() {
    }

    @Test
    void doDeleteLab() {
    }

    @Test
    void doUpdate() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByArtid() {
    }

    @Test
    void findByLabid() {
    }
}