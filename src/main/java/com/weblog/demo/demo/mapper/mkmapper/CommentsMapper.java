package com.weblog.demo.demo.mapper.mkmapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentsMapper {

    @Select("select * from comments")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param id
     * @return
     *
     */
    @Select("select * from comments where article_id=#{n}")
    public List<Map<String,Object>> findById(int id);

    //将来数据来自页面，都是string类型

    /**
     * @Param("cmt") 表示参数的别名，在sql语句中使用
     * @param addcmt
     * @return
     *
     */
    @Insert("insert into comments(user_id,article_id,comment_like_count,comment_date,comment_content)" +
            "value(#{cmt.uid},#{cmt.artid},#{cmt.likecount},#{cmt.date},#{cmt.content})")
    public int addCmt(@Param("cmt") Map<String,String> addcmt);

    /**
     * 根据用户的id修改用户的名称和编号
     *
     * 只要传递多个参数的都可以使用map集合进行封装，可以减少方法的参数个数
     */

    @Update("update comments " +
            " set user_id=#{t.uid},article_id=#{t.artid},comment_like_count=#{t.likecount},comment_date=#{t.date},comment_content=#{t.content}" +
            " where comment_id=#{t.id}")
    public int update(@Param("t") Map<String,String> cmt);

    /**
     * #{id} 习惯写法
     * @param id
     * @return
     */
    @Delete("delete from comments where comment_id=#{id}")
    public int delete(int id);

}

