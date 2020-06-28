package com.weblog.demo.demo.mapper.zymapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserFriMapper {
    //找出该id的所有好友
    @Select("select * from user_friends where user_id = #{id}")
    public List<Map<String,Object>> findFriByid (int id);

    //该表有id和user_id两个表项，这里用到userid
    @Insert("insert into user_friends(user_id,user_friends_id,user_note,user_status)" +
            "value(#{user.id},#{user.friendsid},#{user.note}," +
            "#{user.status})")
    public int save(@Param("user") Map<String,String> map);

    //用户id和好友id来删除id
    @Delete("delete from user_friends where user_id =#{uid} and user_friends_id =#{fid}")
    public int delete(@Param("uid") int userid,@Param("fid") int friid);

    //一对一修改备注和状态
    @Update("update user_friends " +
            " set user_id=#{user.id},user_friends_id=#{user.friendsid}," +
            "user_note=#{user.note}" +
            " where user_id=#{user.id} and user_friends_id =#{user.friendsid}")
    public int updatenote(@Param("user") Map<String,String> user);

    @Update("update user_friends " +
            " set user_id=#{user.id},user_friends_id=#{user.friendsid}," +
            "user_status=#{user.status}" +
            " where user_id=#{user.id} and user_friends_id =#{user.friendsid}")
    public int updatestatus(@Param("user") Map<String,String> user);


}
