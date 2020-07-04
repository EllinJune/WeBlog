package com.weblog.demo.demo.controller.djycontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import java.nio.charset.Charset;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ArticleControllerTest {
    //模拟客户端
    @Resource
    private MockMvc mockMvc;
    @Test
    public void savearticle() throws Exception {
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.post("/savearticle").param("title","1111").
                param("content","打打");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(str);
    }

    @Test
    public void delete() throws Exception {
        MvcResult ret=mockMvc.perform(MockMvcRequestBuilders.get("/delete").param("id","7")).andReturn();
        String str=ret.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(str);
    }

    @Test
    public void update() throws Exception {
        MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.post("/edit").param("title","313").
                param("content","发四").param("id","5");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(str);
    }


    @Test
    public void saveComment() throws Exception {
        MockHttpServletRequestBuilder builder= MockMvcRequestBuilders.post("/savecomment").param("content","1111");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(str);
    }

    @Test
    public void message() {
    }

    @Test
    public void findUserId() {
    }

    @Test
    public void findUserPhoto() {
    }
}