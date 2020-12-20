package com.qh.service;

import java.util.List;
import java.util.Map;

import com.qh.model.BookInfo;

public interface BookInfoService {
	/**
	 * 查询所有图书信息
	 * @param mapParam 
	 */
	public List<BookInfo> findBookInfoList(Map map);
	public int findBookInfoCount();
}
