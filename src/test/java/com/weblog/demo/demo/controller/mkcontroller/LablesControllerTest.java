package com.weblog.demo.demo.controller.mkcontroller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class LablesControllerTest {

    @Resource
    private LablesController labController;

    @Test
    void findAll() {
        List<Map<String,Object>> lablist= labController.findAll();
        System.out.println(lablist);
    }

    @Test
    void findByLabid() {
        Map<String,Object> lable= labController.findByLabid(1);
        System.out.println(lable);
    }

    @Test
    void save() {
    }

    @Test
    void deleteLab() {
    }

    @Test
    void update() {
    }
}