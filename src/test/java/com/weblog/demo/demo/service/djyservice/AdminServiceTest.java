package com.weblog.demo.demo.service.djyservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Resource
    AdminService adminService;
    @Test
    public void doDeleteArticles() {
        boolean n=adminService.doDeleteArticles(3);
        System.out.println(n);
    }

    @Test
    public void doDeletePhotos() {
        boolean n=adminService.doDeletePhotos(2);
        System.out.println(n);
    }

    @Test
    public void doDeleteComments() {
        boolean n=adminService.doDeleteComments(3);
        System.out.println(n);
    }
}