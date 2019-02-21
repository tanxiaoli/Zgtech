package com.zgtech.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zgtech.dao.NoticeMapper;
import com.zgtech.dto.Notice;
import com.zgtech.service.NoticeService;


@Service
@Transactional
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper noticeDao;
	@Override
	public List<Notice> getNoticeList() {
		// TODO Auto-generated method stub
		
		
		return noticeDao.getNoticeList();
	}
	@Override
	public int addNotice(Notice notice) {
		return noticeDao.addNotice(notice);
		
	}

}
