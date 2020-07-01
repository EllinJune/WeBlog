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
class ArticleLableSetMapperTest {

    @Resource
    private ArticleLableSetMapper artlabsetmapper;
    @Test
    void findAll() {
        List<Map<String,Object>> map=artlabsetmapper.findAll();
        System.out.println(map);
    }

    @Test
    void findById() {
        List<Map<String,Object>> map=artlabsetmapper.findByArtid(1);
        System.out.println(map);
    }

    @Test
    void addLabSet() {
        Map<String,String> addlabset=new HashMap<>();
        addlabset.put("artid","1");
        addlabset.put("labid","1");
        int n=artlabsetmapper.addLabSet(addlabset);
        assertEquals(1,n);
    }

    @Test
    void update() {
        Map<String,String> addlabset=new HashMap<>();
        addlabset.put("artid","1");
        addlabset.put("labid","2");
        int n=artlabsetmapper.update(addlabset);
        assertEquals(1,n);
    }

    @Test
    void findByLabid() {
        List<Map<String,Object>> map=artlabsetmapper.findByLabid(1);
        System.out.println(map);
    }

    @Test
    void deleteArt() {
        int n = artlabsetmapper.deleteArt(1);
        assertEquals(1,n);
    }

    @Test
    void deleteLab() {
        int n = artlabsetmapper.deleteLab(1);
        assertEquals(1,n);
    }
}