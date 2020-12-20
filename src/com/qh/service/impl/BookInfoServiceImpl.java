package com.qh.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qh.mapper.BookInfoMapper;
import com.qh.model.BookInfo;
import com.qh.service.BookInfoService;

@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class BookInfoServiceImpl implements BookInfoService {
	@Resource
	private BookInfoMapper mapper;
	
	public List<BookInfo> findBookInfoList(Map map) {
		return mapper.findBookInfoList(map);
	}
	public int findBookInfoCount() {
		return mapper.findBookInfoCount();
	}
}
