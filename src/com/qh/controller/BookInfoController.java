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
public class BookInfoController{

	@Autowired
	private BookInfoService bookInfoService;
	
	/**
	 * 查询图书列表
	 */
	@RequestMapping("/findBookInfoList")
	public void findBookInfoList(HttpServletRequest request,HttpServletResponse response) throws Exception {
		String pageIndex=request.getParameter("pageIndex");//页面索引，0：第一页，1：第二页，依次类推
	    String pageSize=request.getParameter("pageSize");//每页多少条
	    String name=request.getParameter("key");//搜索功能：获取搜索参数值（用户姓名）
	    
	    HashMap mapParam=new HashMap();
	    mapParam.put("pageSize", Integer.parseInt(pageSize));
	    mapParam.put("rowNum", Integer.parseInt(pageSize)*Integer.parseInt(pageIndex));
	    mapParam.put("name", name);
	        
	    List<BookInfo> bookInfoList = bookInfoService.findBookInfoList(mapParam);
	    int count=bookInfoService.findBookInfoCount();//查询数据总数
	    
	    HashMap map=new HashMap();
	    map.put("total", count);
	    map.put("data", bookInfoList);
	    
	    String json = JSON.encode(map);
	    System.out.println(json);
	    //向前端返回数据
	    response.getWriter().write(json);
	}
}
