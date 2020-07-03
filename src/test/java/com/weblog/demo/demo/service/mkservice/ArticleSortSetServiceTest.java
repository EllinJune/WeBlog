package com.weblog.demo.demo.service.mkservice;

import com.weblog.demo.demo.mapper.mkmapper.ArticleSortMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//我们spring框架就知道，在BeanFactory中要管理该类
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ArticleSortSetServiceTest {

    @Resource
    private ArticleSortSetService artsortsetService;

    @Test
    void finduserByid() {
        List<String> list = artsortsetService.finduserByid(1005);
        System.out.println(list);
    }
}