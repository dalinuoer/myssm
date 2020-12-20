package com.qh.mapper;

import java.util.List;
import java.util.Map;

import com.qh.model.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    
    /**
     * 查询用户列表
     * @param map 
     */
    List<UserInfo> findUserInfoList(Map map);
    
    int findUserInfoCount();

	UserInfo userLogin(UserInfo userInfo);
}