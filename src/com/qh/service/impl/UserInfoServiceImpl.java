package com.qh.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qh.mapper.UserInfoMapper;
import com.qh.model.UserInfo;
import com.qh.service.UserInfoService;

@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoMapper mapper;

	public List<UserInfo> findUserInfoList(Map map) {
		return mapper.findUserInfoList(map);
	}
	
	public int findUserInfoCount() {
		return mapper.findUserInfoCount();
	}
	/**
	 * 用户登录
	 * @param userInfo
	 * @return
	 */
	public UserInfo userLogin(UserInfo userInfo) {
		return mapper.userLogin(userInfo);
	}
	/**
	 * 添加或修改用户
	 * @param userInfo
	 * @return
	 */
	public int addUserInfo(UserInfo userInfo) {
		return mapper.insertSelective(userInfo);
	}
}
