package com.qfedu.service;


import com.qfedu.domain.User;

public interface UserService {

   User login(String email,String password);

   int register(User user);

   int modifyPassword(int uid, String oldpassword,String newpassword);

   int insertVcode(int uid,String vcode);

   User getVcode(int id);

   int newPassword(int uid,String newpws);

   int modifyName(int uid,String name);

   User selectUid(int uid);

   int updateHeadimg(int uid,String headimg);
}
