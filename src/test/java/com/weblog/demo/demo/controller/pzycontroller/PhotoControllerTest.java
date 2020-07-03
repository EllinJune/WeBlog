package com.weblog.demo.demo.controller.pzycontroller;

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
public class PhotoControllerTest {

    @Resource
    private MockMvc mockMvc;
    @Test
    public void album() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/album")
                .param("id","1");
        MvcResult result=mockMvc.perform(builder).andReturn();
        String list=result.getResponse().getContentAsString(Charset.forName("utf-8"));
        if(list!=null)
            System.out.println(list);
        else System.out.println(list);
    }

    @Test
    public void createAlbum() throws Exception {
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/createAlbum")
                .param("name","明天")
                .param("userId","1");
        MvcResult result=mockMvc.perform(builder).andReturn();
        String string=result.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(string);
    }

    @Test
    public void updateAlbum() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/updateAlbum")
                        .param("name","昨天")
                        .param("id","5");
        MvcResult result=mockMvc.perform(builder).andReturn();
        String string=result.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(string);
    }

    @Test
    public void deleteAlbum() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/deleteAlbum")
                        .param("id","5");
        MvcResult result=mockMvc.perform(builder).andReturn();
        String string=result.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(string);
    }


    @Test
    public void show() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/show")
                        .param("id","4");
        MvcResult result=mockMvc.perform(builder).andReturn();
        String list=result.getResponse().getContentAsString(Charset.forName("utf-8"));
        if(list!=null)
            System.out.println(list);
        else System.out.println(list);
    }


    @Test
    public void deletePhoto() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/deletePhoto")
                        .param("id","3");
        MvcResult result=mockMvc.perform(builder).andReturn();
        String string=result.getResponse().getContentAsString(Charset.forName("utf-8"));
        System.out.println(string);
    }
}