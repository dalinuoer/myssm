package com.qh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qh.model.BookInfo;
import com.qh.model.UserInfo;
import com.qh.service.BookInfoService;
import com.qh.service.UserInfoService;
import com.qh.util.JSON;

@Controller
//@RequestMapping("/user")
public class UserInfoController{

	@Autowired
	private UserInfoService userInfoService; // 控制反转（依赖注入）
	
	/**
	 * 查询用户列表
	 */
	@RequestMapping("/findUserInfoList")
	public void findUserInfoList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String pageIndex=request.getParameter("pageIndex");//页面索引，0：第一页，1：第二页，依次类推
	    String pageSize=request.getParameter("pageSize");//每页多少条
	    String username=request.getParameter("key");//搜索功能：获取搜索参数值（用户姓名）
	    
	    HashMap mapParam=new HashMap();
	    mapParam.put("pageSize", Integer.parseInt(pageSize));
	    mapParam.put("rowNum", Integer.parseInt(pageSize)*Integer.parseInt(pageIndex));
	    mapParam.put("username", username);
	        
	    List<UserInfo> userInfoList = userInfoService.findUserInfoList(mapParam);
	    int count=userInfoService.findUserInfoCount();//查询数据总数
	    
	    HashMap map=new HashMap();
	    map.put("total", count);
	    map.put("data", userInfoList);
	    
	    String json = JSON.encode(map);
	    System.out.println(json);
	    //向前端返回数据
	    response.getWriter().write(json);
	}
	
	/**
	 * 登录
	 */
	@RequestMapping("/userLogin")
	public void userLogin(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
	    String pwd = request.getParameter("pwd");
	    
	    UserInfo userInfo = new UserInfo();
	    userInfo.setUserno(username);
	    userInfo.setPassword(pwd);
	        
	    UserInfo u = userInfoService.userLogin(userInfo);
	    if (u != null) {
	    	request.getSession().setAttribute("user", u);
	    	response.getWriter().write("success");
	    } else {
	    	response.getWriter().write("fail");
	    }
	}
	
	/**
	 * 添加用户
	 */
	@RequestMapping("/addUserInfo")
	public void addUserInfo(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String userid = request.getParameter("userid");
		String userno = request.getParameter("userno");
	    String password = request.getParameter("password");
	    String username = request.getParameter("username");
	    String sex = request.getParameter("sex");
	    String address = request.getParameter("address");
	    String phone = request.getParameter("phone");
	    String role = request.getParameter("role");
	    
	    UserInfo userInfo = new UserInfo();
	    if (userid != null && !userid.equals("")) {
	    	userInfo.setUserid(Long.parseLong(userid));
		}
	    userInfo.setUserno(userno);
	    userInfo.setPassword(password);
	    userInfo.setUsername(username);
	    userInfo.setSex(sex);
	    userInfo.setAddress(address);
	    userInfo.setPhone(phone);
	    userInfo.setRole(Integer.parseInt(role));
	        
	    int result = userInfoService.addUserInfo(userInfo);
	    if (result > 0) {
	    	response.getWriter().write("success");
	    } else {
	    	response.getWriter().write("fail");
	    }
	}
}
