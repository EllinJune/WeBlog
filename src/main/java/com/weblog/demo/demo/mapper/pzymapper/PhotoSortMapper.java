package com.weblog.demo.demo.mapper.pzymapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface PhotoSortMapper {

    /**
     * 添加相册名
     * @param map
     * @return
     */
    @Insert("insert into photo_sort(photo_sort_name)" +
            " value(#{sort.name})")
    public int save(@Param("sort") Map<String,String> map);


    /**
     * 传入id，修改相册名称
     * @param map
     * @return
     */
    @Update("update photo_sort" +
            " set photo_sort_name=#{sort.name}" +
            " where photo_sort_id=#{sort.id}")
    public int update(@Param("sort") Map<String,String> map);

    /**
     * 删除相册
     * @param id
     * @return
     */
    @Delete("delete from photo_sort" +
            " where photo_id=#{id}")
    public int delete(int id);

    @Select("select * from  photo_sort")
    public List<Map<String,Object>> findAll();

}
