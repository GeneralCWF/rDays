package com.qfedu.mapper;

import com.qfedu.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User slectEmail(String email);

    int updatePassword(@Param("uid")int uid, @Param("oldpwd")String oldpwd, @Param("newpwd")String newpwd);

    int saveVcode(@Param("uid") int uid,@Param("vcode") String vcode);

    User selectVcode(int uid);

    int newPassword(@Param("uid")int uid,@Param("newpwd")String newpwd);

    int updateName(@Param("uid")int uid, @Param("name")String name);

    int updateHeadig(@Param("uid")int uid,@Param("headimg")String headimg);
}