package com.weblog.demo.demo.service.pzyservice;

import com.weblog.demo.demo.mapper.pzymapper.PhotoMapper;
import com.weblog.demo.demo.mapper.pzymapper.PhotoSortMapper;
import com.weblog.demo.demo.mapper.pzymapper.PhotoSortSetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务
 * 创建相册，修改相册名，删除相册，列出该作者的所有相册
 * 在相册中 上传图片，删除图片
 */
@Service
public class PhotoService {
    @Resource
    private PhotoMapper photoMapper;
    @Resource
    private PhotoSortMapper photoSortMapper;
    @Resource
    private PhotoSortSetMapper photoSortSetMapper;


    //相册的服务：创建、改名、删除、找到用户的所有相册

    /**
     *
     * @param map
     * @return
     */
    public boolean doCreateAlbum(Map<String,String> map){
        boolean flag=false;

        try {
            int r=photoSortMapper.save(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * @param map
     * @return
     */
    public boolean doUpdateAlbum(Map<String,String> map){
        boolean flag=false;

        try {
            int r=photoSortMapper.update(map);
            if(r>0){
                flag=true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * @param map
     * @return
     */
    public boolean doDeleteAlbum(Map<String,String> map){
        boolean flag=false;
        try {
            int id=Integer.parseInt(map.get("id"));
            int r=photoSortMapper.delete(id);
            if(r>0){
                flag=true;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     *
     * @param map
     * @return
     */
    public List<Map<String,Object>> findAlbumByUserId(Map<String,String> map){
        List<Map<String,Object>> list=null;

        try {
            int id=Integer.parseInt(map.get("id"));
            list=photoSortMapper.findByUserId(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return list;
    }

    //图片服务:保存图片、删除图片、找到图片

    /**
     *
     * @param map
     * @return
     */
    public boolean doSave(Map<String,String> map){
        boolean flag=false;

        try {
            int r=photoMapper.save(map);
            if(r>0)
                flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     *
     * @param map
     * @return
     */
    public boolean doDelete(Map<String,String> map){
        boolean flag=false;

        try {
            int id=Integer.parseInt(map.get("id"));
            int r=photoMapper.delete(id);
            if(r>0)
                flag=true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     *
     * @param map
     * @return
     */
    public Map<String,Object> findById(Map<String,String> map){
        Map<String,Object> photo=null;

        try {
            int id=Integer.parseInt(map.get("id"));
            photo=photoMapper.findById(id);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return photo;
    }

    //通过相册找到当下所有图片

    /**
     *
     * @param map
     * @return
     */
    public List<Map<String,Object>> findAllInAlbum(Map<String,String> map){
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        try {
            int id=Integer.parseInt(map.get("id"));
            List<Map<String,Long>> photoList=photoSortSetMapper.findByUserId(id);
            for (Map<String,Long> e : photoList){
                int id1=Integer.parseInt(String.valueOf(e.get("photo_id")));
                list.add(photoMapper.findById(id1));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return list;
    }

}
