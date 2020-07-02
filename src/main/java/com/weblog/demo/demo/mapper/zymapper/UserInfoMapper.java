package com.weblog.demo.demo.mapper.zymapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {

    /**
     * 所有用户
     * @param
     * @return 所有用户 list
     */
    @Select("select * from users")
    public List<Map<String,Object>> findAll();

    /**
     * 用id来查找
     * @param id
     * @return
     */
    @Select("select * from users where user_id = #{id}")
    public Map<String,Object> findById(int id);

    /**
     * 用name查找用户
     * @param name
     * @return List
     */
    @Select("select * from users where user_name = #{name}")
    public Map<String,Object> findByName(String name);

    /**
     * 用户注册
     * @param map
     * @return int
     */
    @Insert("insert into users(user_name,user_pwd,user_profile_photo," +
            "user_reg_time,user_birthday,user_sex," +
            "user_age,user_right)" +
            "value(#{user.name},#{user.pwd},#{user.profilephoto}," +
            "#{user.regtime},#{user.birthday},#{user.sex},#{user.age}," +
            "#{user.right})")
    public int save(@Param("user") Map<String,String> map);

    /**
     * 根据id删除users表的数据
     * @param id
     * @return int
     */
    @Delete("delete from users where user_id =#{id}")
    public int delete(int id);

    /**
     * 更新数据
     * @param user
     * @return int
     */
    @Update("update users " +
            " set user_pwd=#{user.pwd},user_profile_photo=#{user.profilephoto}," +
            "user_birthday=#{user.birthday},user_sex=#{user.sex}," +
            "user_age=#{user.age},user_right=#{user.right}" +
            " where user_name=#{user.name}")
    public int update(@Param("user") Map<String,String> user);


    /**
     * 修改密码
     * @param user
     * @return
     */
    @Update("update users " +
            " set user_pwd=#{user.pwd}" +
            " where user_name=#{user.name}")
    public int updatecode(@Param("user") Map<String,String> user);


    /**
     * 登录验证
     * @param map
     * @return
     */
    @Select("select * from users"+
            " where user_pwd = #{t.pwd}"+
            " and user_name = #{t.name}")
    public Map<String,Object> Login(@Param("t") Map<String,String> map);
}
