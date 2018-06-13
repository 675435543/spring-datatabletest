package com.forezp.dao;

import java.util.List;

import com.forezp.entity.UserInfo;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public interface UserInfoDao {
   
   List<UserInfo> findUserInfoBynameLike(String name);

}
