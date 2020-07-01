package com.weblog.demo.demo.mapper.pzymapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PhotoSortSetMapperTest {

    @Resource
    private PhotoSortSetMapper photoSortSetMapper;

    @Test
    public void save() {
        int n=photoSortSetMapper.save(4,2);
        assertEquals(1,n);
    }

    @Test
    public void delete() {
        int n=photoSortSetMapper.delete(5);
        assertEquals(1,n);
    }

    @Test
    public void findBySortId() {
        List<Map<String, String>> list=photoSortSetMapper.findBySortId(2);
        System.out.println(list);

    }
}