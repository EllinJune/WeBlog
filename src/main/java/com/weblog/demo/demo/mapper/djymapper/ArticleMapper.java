package com.weblog.demo.demo.mapper.djymapper;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper
{
    //寻找文章id
    @Select("select article_id from articles where article_title=#{title}")
    public List<Map<String,Object>> findId(String title);
    //寻找评论者
    @Select("select user_name from comments a INNER JOIN users b on a.user_id=b.user_id")
    public List<Map<String,Object>> findobserver();
    //寻找作者
    @Select("select user_name from articles a INNER JOIN users b on a.user_id=b.user_id")
    public List<Map<String,Object>> findwriter();
    //寻找评论信息
    @Select("select comment_like_count,comment_date,comment_content from comments")
    public List<Map<String,Object>> findcomment();
    //寻找文章信息
    @Select("select article_title,article_content,article_like_count,article_comment_count,article_collection_count,article_date from articles")
    public List<Map<String,Object>> message();

    @Select("select * from articles where article_id=#{id}")
    public Map<String,Object> findartbyid(int id);

    //写文章
    @Insert("insert into articles(article_title,article_content,article_date)" +
            "value(#{article.title},#{article.content},#{article.date})")
    public int saveArticle(@Param("article") Map<String,String> article);
    @Insert("insert into article_sort(article_sort_name)" +
            "value(#{sort.sort_name})")
    public int saveSort(@Param("sort") Map<String,String> sort);
    //写评论
    @Insert("insert into comments(comment_content,comment_date)" +
            "value(#{c.content},#{c.date})")
    public int saveComment(@Param("c") Map<String,String> c);
    //编辑文章
    @Update("update articles " +
            " set article_title=#{t.title},article_content=#{t.content},article_date=#{t.date} " +
            " where article_id=#{t.id}")
    public int updateArticle(@Param("t") Map<String,String> t);
    //删除文章
    @Delete("delete from articles where article_id=#{id}")
    public int delete(int id);
}