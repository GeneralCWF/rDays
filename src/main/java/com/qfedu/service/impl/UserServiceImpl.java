package com.qfedu.service.impl;

import com.qfedu.common.util.MD5Utils;
import com.qfedu.domain.User;
import com.qfedu.mapper.UserMapper;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String email, String password) {

            User user = userMapper.slectEmail(email);
            System.out.println(MD5Utils.md5(password));
            if(user != null) {
                if(Objects.equals(user.getPassword(),MD5Utils.md5(password))){
                    return user;
                }
            }
            return null;

    }

    @Override
    public int register(User user) {

            return userMapper.insert(user);


    }

    @Override
    public int modifyPassword(int uid, String oldpassword, String newpassword) {

        return userMapper.updatePassword(uid,MD5Utils.md5(oldpassword),MD5Utils.md5(newpassword));
    }

    @Override
    public int insertVcode(int uid, String vcode) {
        return userMapper.saveVcode(uid,vcode);
    }

    @Override
    public User getVcode(int id) {
        return userMapper.selectVcode(id);
    }

    @Override
    public int newPassword(int uid, String newpwd) {
        return userMapper.newPassword(uid,newpwd);
    }

    @Override
    public int modifyName(int uid, String name) {
        return userMapper.updateName(uid,name);
    }

    @Override
    public User selectUid(int uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateHeadimg(int uid, String headimg) {
        return userMapper.updateHeadig(uid,headimg);
    }
}
