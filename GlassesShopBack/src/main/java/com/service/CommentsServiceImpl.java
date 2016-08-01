package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CommentsDao;
import com.entity.Comments;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
	@Resource
	private CommentsDao commentsDao;	
	@Override
	public void save(Comments comment) {
		// TODO Auto-generated method stub
		commentsDao.save(comment);
	}
	@Override
	public List<Comments> findByGlassesId(int id) {
		// TODO Auto-generated method stub
		return commentsDao.findByGlasseId(id);
	}

}
