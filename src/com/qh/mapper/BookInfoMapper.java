package com.qh.mapper;

import java.util.List;
import java.util.Map;

import com.qh.model.BookInfo;

public interface BookInfoMapper {
    int deleteByPrimaryKey(Long bookid);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Long bookid);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKeyWithBLOBs(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

	List<BookInfo> findBookInfoList(Map map);

	int findBookInfoCount();
}