package com.weblog.demo.demo.mapper.djymapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdminMapperTest {
    @Resource
    AdminMapper adminMapper;
    @Test
    public void deleteArticles() {
        int n=adminMapper.deleteArticles(3);
        System.out.println(n);
    }

    @Test
    public void deletePhotos() {
        int n=adminMapper.deletePhotos(2);
        System.out.println(n);
    }

    @Test
    public void deleteComments() {
        int n=adminMapper.deleteComments(3);
        System.out.println(n);
    }
}