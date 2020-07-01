package com.weblog.demo.demo.controller.zycontroller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserFriControllerTest {

    @Resource
    private MockMvc mockMvc;
    @Test
    void addFriend() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/addfriend")
                        .param("id","3")
                        .param("friendsid","2")
                        .param("note","sb")
                        .param("status","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void allFriends() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/allfriends")
                        .param("id","3");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void upDateNote() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/editnote")
                        .param("id","4")
                        .param("friendsid","2")
                        .param("note","sb");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void upDateStatus() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/editstatus")
                        .param("id","3")
                        .param("friendsid","2")
                        .param("status","0");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }
}