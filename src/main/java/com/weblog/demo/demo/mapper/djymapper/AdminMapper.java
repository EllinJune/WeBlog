package com.weblog.demo.demo.mapper.djymapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper
{
    //删除文章
    @Delete("delete from articles where article_id=#{id}")
    public int deleteArticles(int id);
    //删除图片
    @Delete("delete from photo where photo_id=#{id}")
    public int deletePhotos(int id);
    //删除评论
    @Delete("delete from comments where comment_id=#{id}")
    public int deleteComments(int id);
    //寻找文章信息
    @Select("select article_id,article_title,user_id from articles")
    public List<Map<String,Object>> articleInfo();
    //寻找图片信息
    @Select("select photo_id,user_id from photo")
    public List<Map<String,Object>> photoInfo();
    //寻找评论信息
    @Select("select comment_id,comment_content,user_id from comments")
    public List<Map<String,Object>> commentInfo();

}