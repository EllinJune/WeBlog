package com.weblog.demo.demo.service.djyservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleServiceTest {
    @Resource
    private ArticleService articleService;
    @Test
    public void doSaveArticle() {
        Map<String,String> map=new HashMap<>();
        map.put("title","tobe");
        map.put("content","张三丰哈萨克较好的卡结束的");
        boolean flag=articleService.doSaveArticle(map);
        assertTrue(flag);
    }

    @Test
    public void doDelete() {
        boolean n=articleService.doDelete(6);
        System.out.println(n);
    }

    @Test
    public void doUpdate() {
        Map<String,String> tea=new HashMap<>();
        tea.put("title","escape");
        tea.put("content","x");
        tea.put("id","3");
        boolean n=articleService.doUpdate(tea);
        System.out.println(n);
    }

    @Test
    public void doSaveComment() {
        Map<String,String> map=new HashMap<>();
        map.put("content","张三丰哈萨克较好的卡结束的");
        boolean flag=articleService.doSaveComment(map);
        assertTrue(flag);
    }

    @Test
    public void doMessage() {
        List<Map<String,Object>> list=articleService.doMessage();
        System.out.println(list);
    }

    @Test
    public void doFindComment() {
        List<Map<String,Object>> list=articleService.doFindComment();
        System.out.println(list);
    }

    @Test
    public void doFindWriter() {
        List<Map<String,Object>> list=articleService.doFindWriter();
        System.out.println(list);
    }

    @Test
    public void doFindObserver() {
        List<Map<String,Object>> list=articleService.doFindObserver();
        System.out.println(list);
    }

    @Test
    public void doSaveSort() {
        Map<String,String> map=new HashMap<>();
        map.put("sort_name","学术");
        boolean flag=articleService.doSaveSort(map);
        assertTrue(flag);
    }

    @Test
    public void doFindId() {
        Map<String,Object> list=articleService.doFindId("时间");
        System.out.println(list);
    }

    @Test
    public void doFindUserInfo() {
        Map<String,Object> list=articleService.doFindUserInfo("Moon");
        System.out.println(list);
    }

}