package com.weblog.demo.demo.mapper.djymapper;
import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface ArticleMapper
{
    @Select("select * from articles where article_id=#{id}")
    public Map<String,Object> findById(int id);
    //写文章
    @Insert("insert into articles(article_title,article_content)" +
            "value(#{article.title},#{article.content})")
    public int saveArticle(@Param("article") Map<String,String> article);
    //写评论
    @Insert("insert into comments(comment_content)" +
            "value(#{comment.content})")
    public int saveComment(@Param("comment") Map<String,String> comment);
    //编辑文章
    @Update("update articles " +
            " set article_title=#{t.title},article_content=#{t.content} " +
            " where article_id=#{t.id}")
    public int updateArticle(@Param("t") Map<String,String> t);
    @Delete("delete from articles where article_id=#{id}")
    public int delete(int id);
}