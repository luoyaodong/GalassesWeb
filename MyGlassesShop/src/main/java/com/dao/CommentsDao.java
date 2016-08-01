package com.dao;

import java.util.List;

import com.entity.Comments;

public interface CommentsDao {

	void save(Comments comment);

	List<Comments> findByGlasseId(int id);

}
