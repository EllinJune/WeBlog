package com.weblog.demo.demo.mapper.djymapper;

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
public class ArticleMapperTest {
    @Resource
    ArticleMapper articleMapper;
    @Test
    public void saveArticle() {
        Map<String,String> map=new HashMap<>();
        map.put("title","起飞");
        map.put("content","爱神的箭奥斯卡厚度去武汉丢弃");
        int n=articleMapper.saveArticle(map);
    }

    @Test
    public void saveComment() {
        Map<String,String> map=new HashMap<>();
        map.put("content","爱神的箭奥斯卡厚度去武汉丢弃");
        int n=articleMapper.saveComment(map);
    }

    @Test
    public void updateArticle() {
        Map<String,String> tea=new HashMap<>();
        tea.put("title","起飞");
        tea.put("content","肉蛋葱鸡");
        tea.put("id","1");
        int n=articleMapper.updateArticle(tea);
        System.out.println(n);
    }

    @Test
    public void delete() {
        int n=articleMapper.delete(2);
        System.out.println(n);
    }


    @Test
    public void message() {
        List<Map<String,Object>> list=articleMapper.message();
        System.out.println(list);
    }

    @Test
    public void findcomment() {
        List<Map<String,Object>> list=articleMapper.findcomment();
        System.out.println(list);
    }

    @Test
    public void findwriter() {
        List<Map<String,Object>> list=articleMapper.findwriter();
        System.out.println(list);
    }

    @Test
    public void findobserver() {
        List<Map<String,Object>> list=articleMapper.findobserver();
        System.out.println(list);
    }

    @Test
    public void saveSort() {
        Map<String,String> map=new HashMap<>();
        map.put("sort_name","感悟");
        int n=articleMapper.saveSort(map);
    }

    @Test
    public void findId() {
        Map<String,Object> list=articleMapper.findId("时间");
        System.out.println(list);
    }

    @Test
    public void findUserInfo() {
        Map<String,Object> list=articleMapper.findUserInfo("Moon");
        System.out.println(list);
    }

}