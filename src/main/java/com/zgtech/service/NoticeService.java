package com.zgtech.service;

import java.util.List;

import com.zgtech.dto.Notice;

public interface NoticeService {

	
	List<Notice> getNoticeList();

	int addNotice(Notice notice);

}
