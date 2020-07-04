package com.weblog.demo.demo.mapper.mkmapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface LablesMapper {

    @Select("select * from lables")
    public List<Map<String,Object>> findAll();

    /**
     * #{id} 表示一个占位符，用于通过变量赋值
     * @param labid
     * @return
     *
     */
    @Select("select * from lables where lable_id=#{n}")
    public Map<String,Object> findByLabid(int labid);

    //将来数据来自页面，都是string类型

    /**
     * @Param("cmt") 表示参数的别名，在sql语句中使用
     * @param addlab
     * @return
     *
     */
    @Insert("insert into lables(lable_id,lable_name)" +
            "value(#{lab.id},#{lab.name})")
    public int addLable(@Param("lab") Map<String,String> addlab);

    /**
     * 根据用户的id修改用户的名称和编号
     *
     * 只要传递多个参数的都可以使用map集合进行封装，可以减少方法的参数个数
     */

    @Update("update lables " +
            " set lable_name=#{t.name}" +
            " where lable_id=#{t.id}")
    public int update(@Param("t") Map<String,String> lable);


    /*
    *
    *
    *
    * */
   @Delete("delete from article_lable_set where lable_id=#{id}")
    public int deleteLabSet(int labsetid);

    @Delete("delete from lables where lable_id=#{id}")
    public int deleteLab(int labid);

}
