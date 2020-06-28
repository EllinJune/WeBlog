package com.weblog.demo.demo.mapper.zymapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {
    //所有用户
    @Select("select * from users")
    public List<Map<String,Object>> findAll();

    //用id来查找
    @Select("select * from users where user_id = #{id}")
    public Map<String,Object> findById(int id);

    //以名称来查找
    @Select("select * from users where user_name = #{name}")
    public List<Map<String,Object>> findByName(String name);

    @Insert("insert into users(user_name,user_pwd,user_profile_photo," +
            "user_reg_time,user_birthday,user_sex," +
            "user_age,user_right)" +
            "value(#{user.name},#{user.pwd},#{user.profilephoto}," +
            "#{user.regtime},#{user.birthday},#{user.sex},#{user.age}," +
            "#{user.right})")
    public int save(@Param("user") Map<String,String> map);
    //根据id删除users表的数据
    @Delete("delete from users where user_id =#{id}")
    public int delete(int id);

    @Update("update users " +
            " set user_name=#{user.name},user_pwd=#{user.pwd},user_profile_photo=#{user.profilephoto}," +
            "user_reg_time=#{user.regtime},user_birthday=#{user.birthday},user_sex=#{user.sex}," +
            "user_age=#{user.age},user_right=#{user.right}" +
            " where user_id=#{user.id}")
    public int update(@Param("user") Map<String,String> user);
}