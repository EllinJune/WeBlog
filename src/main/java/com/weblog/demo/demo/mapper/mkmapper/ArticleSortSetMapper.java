package com.weblog.demo.demo.mapper.mkmapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleSortSetMapper {

    @Select("select * from article_sort_set")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param artid
     * @return
     *
     */
    @Select("select * from article_sort_set where article_id=#{n}")
    public List<Map<String,Object>> findByArtid(int artid);

    @Select("select * from article_sort_set where article_sort_id=#{n}")
    public List<Map<String,Object>> findByLabid(int artsortid);
    //将来数据来自页面，都是string类型
    @Select("select * from articles where article_id=#{n}")
    public List<Map<String,Object>> findByartidFromArts(int artid);
    @Select("select user_id from articles where article_id=#{n}")
    public String findByuseridFromArts(int artid);
    @Select("select article_id from article_sort_set where article_sort_id=#{n}")
    public List<String> findByArtSortid(int artsortid);
    @Select("select user_id from articles where article_id=#{n}")
    public int finduserByArtid(int artid);

    /**
     * @Param("cmt") 表示参数的别名，在sql语句中使用
     * @param addlabset
     * @return
     *
     */
    @Insert("insert into article_sort_set(article_id,article_sort_id)" +
            "value(#{art.id},#{art.sortid})")
    public int addLabSet(@Param("art") Map<String,String> addlabset);

    /**
     * 根据用户的id修改用户的名称和编号
     *
     * 只要传递多个参数的都可以使用map集合进行封装，可以减少方法的参数个数
     */

    @Update("update article_sort_set " +
            " set article_sort_id=#{t.sortid}" +
            " where article_id=#{t.artid}")
    public int update(@Param("t") Map<String,String> labset);

    /**
     * #{id} 习惯写法
     * @param artid
     * @return
     */
    @Delete("delete from article_sort_set where article_id=#{id}")
    public int deleteArt(int artid);

    @Delete("delete from article_sort_set where article_sort_id=#{id}")
    public int deleteLab(int sortid);

}

