package com.zgtech.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.zgtech.dto.Notice;
import com.zgtech.dto.User;
@Repository
public interface NoticeMapper {

	List<Notice> getNoticeList();

	int addNotice(@Param("notice") Notice notice);

}
