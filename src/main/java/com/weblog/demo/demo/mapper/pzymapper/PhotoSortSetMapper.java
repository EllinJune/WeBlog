package com.weblog.demo.demo.mapper.pzymapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 对应photo_sort_set表
 * 属性：photo_id,photo_sort_id
 */
@Mapper
public interface PhotoSortSetMapper {

    /**
     * 在相册中添加图片
     * @param photoId
     * @param sortId
     * @return
     */
    @Insert("insert into photo_sort_set(photo_id,photo_sort_id)" +
            " value(#{photoId},#{sortId})")
    public int save(int photoId,int sortId);


    /**
     * 删除相册中的相片
     * @param id
     * @return
     */
    @Delete("delete from photo_sort_set" +
            " where photo_id=#{id}")
    public int delete(int id);

    /**
     * 找到一个相册中的所有图片
     * @param id
     * @return
     */
    @Select("select photo_id from  photo_sort_set" +
            " where photo_sort_id=#{id}")
    public List<Map<String,Long>> findBySortId(int id);

    @Select("select photo_id from photo" +
            " where user_id=#{id}")
    public  List<Map<String,Long>> findByUserId(int id);

}
