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
class UserInfoControllerTest {
    @Resource
    private UserInfoController userInfoController;

    /**
     * 模拟客户端浏览器向服务器发送请求
     */
    @Resource
    private MockMvc mockMvc;
    @Test
    void findById() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/userinfo")
                        .param("id","1");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void reg() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/userreg")
                        .param("name","马云")
                        .param("pwd","121")
                        .param("profilephoto","zd")
                        .param("regtime","2018-9-9 18:00:00")
                        .param("birthday","2000-9-9")
                        .param("sex","男")
                        .param("age","222")
                        .param("right","0");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void delete() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/deleteuser")
                        .param("id","6");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);

    }

    @Test
    void update() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/edituser")
                        .param("name","马云")
                        .param("pwd","121")
                        .param("profilephoto","zd")
                        .param("regtime","2018-9-9 18:00:00")
                        .param("birthday","2000-9-9")
                        .param("sex","女")
                        .param("age","222")
                        .param("right","0");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void searchuser() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/searchuser")
                        .param("name","马云");

        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void login() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/login")
                        .param("pwd","121")
                        .param("name","马云");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }

    @Test
    void updateCode() throws Exception{
        MockHttpServletRequestBuilder builder=
                MockMvcRequestBuilders.post("/editpwd")
                        .param("pwd","121")
                        .param("name","zy");
        MvcResult rst=mockMvc.perform(builder).andReturn();
        String str=rst.getResponse().getContentAsString(Charset.forName("UTF-8"));
        System.out.println(str);
    }
}