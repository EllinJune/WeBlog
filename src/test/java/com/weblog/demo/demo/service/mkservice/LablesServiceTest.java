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
class LablesSetServiceTest {

    @Resource
    private LablesService lableService;

    @Test
    void doSave() {
        Map<String,String> addlab=new HashMap<>();
        addlab.put("id","100");
        addlab.put("name","不知道");
        boolean flag=lableService.doSave(addlab);
        assertTrue(flag);
    }

    @Test
    void doDeleteArt() {
    }

    @Test
    void doDeleteLab() {
        Map<String,String> map=new HashMap<>();
        map.put("labid","1");
        lableService.doDeleteLab(map);

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