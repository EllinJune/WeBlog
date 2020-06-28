package com.weblog.demo.demo.mapper.zymapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {
    //所有用户
    @Select("select * from users")
    public List<Map<String,Object>> findAll();

    @Select("select * from users where user_id = #{id}")
    public Map<String,Object> findById(int id);

    @Select("select * from users where user_name = #{name}")
    public List<Map<String,Object>> findByName(String name);

    @Insert("insert into users(user_name,user_pwd,user_profile_photo," +
            "user_reg_time,user_birthday,user_sex," +
            "user_age,user_right)" +
            "value(#{user.name},#{user.pwd},#{user.profilephoto}," +
            "#{user.regtime},#{user.birthday},#{user.sex},#{user.age}," +
            "#{user.right})")
    public int save(@Param("user") Map<String,String> map);
}
