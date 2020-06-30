package com.weblog.demo.demo.mapper.mkmapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleLableSetMapper {

    @Select("select * from article_lable_set")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param artid
     * @return
     *
     */
    @Select("select * from article_lable_set where article_id=#{n}")
    public List<Map<String,Object>> findByArtid(int artid);

    @Select("select * from article_lable_set where lable_id=#{n}")
    public List<Map<String,Object>> findByLabid(int labid);
    //将来数据来自页面，都是string类型

    /**
     * @Param("cmt") 表示参数的别名，在sql语句中使用
     * @param addlabset
     * @return
     *  Map<String, String> map=new HashMap<>();
     *  map.put("name","张老师");
     *  map.put("sex","男");
     *  map.put("no","10006");
     */
    @Insert("insert into article_lable_set(article_id,lable_id)" +
            "value(#{artlab.artid},#{artlab.labid})")
    public int addLabSet(@Param("artlab") Map<String,String> addlabset);

    /**
     * 根据用户的id修改用户的名称和编号
     *
     * 只要传递多个参数的都可以使用map集合进行封装，可以减少方法的参数个数
     */

    @Update("update article_lable_set " +
            " set lable_id=#{t.labid}" +
            " where article_id=#{t.artid}")
    public int update(@Param("t") Map<String,String> labset);

    /**
     * #{id} 习惯写法
     * @param artid
     * @return
     */
    @Delete("delete from article_lable_set where article_id=#{id}")
    public int deleteArt(int artid);

    @Delete("delete from article_lable_set where lable_id=#{id}")
    public int deleteLab(int labid);

}
