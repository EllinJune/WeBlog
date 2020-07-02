package com.weblog.demo.demo.mapper.mkmapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleSortMapper {

    @Select("select * from article_sort")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param labid
     * @return
     *
     */
    @Select("select * from article_sort where article_sort_id=#{n}")
    public Map<String,Object> findByLabid(int labid);

    //将来数据来自页面，都是string类型

    /**
     * @Param("cmt") 表示参数的别名，在sql语句中使用
     * @param addlab
     * @return
     *  Map<String, String> map=new HashMap<>();
     *  map.put("name","张老师");
     *  map.put("sex","男");
     *  map.put("no","10006");
     */
    @Insert("insert into article_sort(article_sort_id,article_sort_name)" +
            "value(#{artsort.id},#{artsort.name})")
    public int addLable(@Param("artsort") Map<String,String> addlab);

    /**
     * 根据用户的id修改用户的名称和编号
     *
     * 只要传递多个参数的都可以使用map集合进行封装，可以减少方法的参数个数
     */

    @Update("update article_sort " +
            " set article_sort_name=#{t.name}" +
            " where article_sort_id=#{t.id}")
    public int update(@Param("t") Map<String,String> lable);


    /*
     * 注意这个方法还有一个bug未解决，当lable_id被其他表使用时，就不能成功删除
     *
     *
     * */
    @Delete("delete from article_sort where article_sort_id=#{id}")
    public int deleteLabSet(int labsetid);

    @Delete("delete from article_sort_set where article_sort_id=#{id}")
    public int deleteLab(int labid);

}
