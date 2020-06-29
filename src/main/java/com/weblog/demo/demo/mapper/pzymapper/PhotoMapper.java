package com.weblog.demo.demo.mapper.pzymapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 对应photo表
 * 属性：photo_id,user_id,photo_save_path
 */
@Mapper
public interface PhotoMapper {

    /**
     * 通过photo_id找到图片
     * @param id
     * @return
     */
    @Select("select * from photo where photo_id=#{n}")
    public Map<String,Object> findById(int id);

    /**
     * 加入图片
     * 传入user_id,photo_save_path
     * @param map
     * @return
     */
    @Insert("Insert into photo(user_id,photo_save_path)" +
            " value(#{photo.userId},#{photo.savePath})")
    public int save(@Param("photo") Map<String, String> map);

    /**
     * 删除图片
     * 传入photo_id
     * @param id
     * @return
     */
    @Delete("delete from photo where photo_id=#{n}")
    public int delete(int id);

}
