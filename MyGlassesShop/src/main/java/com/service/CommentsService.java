package com.service;

import java.util.List;

import com.entity.Comments;

public interface CommentsService {

	void save(Comments comment);

	List<Comments> findByGlassesId(int id);

}
