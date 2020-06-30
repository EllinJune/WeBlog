package com.weblog.demo.demo.controller.mkcontroller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ArticleLableSetControllerTest {

    @Resource
    private ArticleLableSetController artlabsetController;

    @Test
    void findByArtid() {
        List<Map<String,Object>> lablist= artlabsetController.findByArtid(1);
        System.out.println(lablist);
    }

    @Test
    void findByLabid() {
    }

    @Test
    void save() {
    }

    @Test
    void deleteArt() {
    }

    @Test
    void deleteLab() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
        List<Map<String,Object>> lablist= artlabsetController.findAll();
        System.out.println(lablist);
    }
}