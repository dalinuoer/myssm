package com.qh.service;
import java.util.List;
import java.util.Map;

import com.qh.model.UserInfo;

public interface UserInfoService {
	/**
	 * 查询所有用户信息
	 * @param mapParam 
	 */
	public List<UserInfo> findUserInfoList(Map map);
	/**
	 * 查询用户总数
	 * @return
	 */
	public int findUserInfoCount();
	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 */
	public UserInfo userLogin(UserInfo userInfo);
	/**
	 * 添加或修改用户
	 * @param userInfo
	 * @return
	 */
	public int addUserInfo(UserInfo userInfo);
}
