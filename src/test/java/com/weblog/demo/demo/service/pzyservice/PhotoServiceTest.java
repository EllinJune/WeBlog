package com.weblog.demo.demo.service.pzyservice;

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
public class PhotoServiceTest {

    @Resource
    private PhotoService photoService;

    @Test
    public void doCreateAlbum() {
        Map<String,String> map=new HashMap<>();
        map.put("name","明天");
        map.put("userId","1");
        boolean flag=photoService.doCreateAlbum(map);
        assertTrue(flag);

    }

    @Test
    public void doUpdateAlbum() {
        Map<String,String> map=new HashMap<>();
        map.put("name","后天");
        map.put("id","4");
        boolean flag=photoService.doUpdateAlbum(map);
        assertTrue(flag);
    }

    @Test
    public void doDeleteAlbum() {
        Map<String,String> map=new HashMap<>();
        map.put("id","3");
        boolean flag=photoService.doDeleteAlbum(map);
        assertTrue(flag);
    }

    @Test
    public void findAlbumByUserId() {
        Map<String,String> map=new HashMap<>();
        map.put("id","1");
        List<Map<String,Object>> list=photoService.findAlbumByUserId(map);
        System.out.println(list);

    }

    @Test
    public void doSave() {
        Map<String,String> map=new HashMap<>();
        map.put("userId","1");
        map.put("savePath","./img");
        boolean flag=photoService.doSave(map);
        assertTrue(flag);
    }

    @Test
    public void doDelete() {
        Map<String,String> map=new HashMap<>();
        map.put("id","4");
        boolean flag=photoService.doDelete(map);
        assertTrue(flag);
    }

    @Test
    public void findById() {
        Map<String,String> map=new HashMap<>();
        map.put("id","5");
        Map<String,Object> photo=photoService.findById(map);
        System.out.println(photo);
    }

    @Test
    public void findAllInAlbum() {
        Map<String,String> map=new HashMap<>();
        map.put("id","4");
        List<Map<String,Object>> list=photoService.findAllInAlbum(map);
        System.out.println(list);
    }
}