package com.dao;

import java.util.List;

import com.entity.Image;

public interface ImageDao {

	void save(Image image);

	List<Image> getImageByUserId(int id);

	String findName(int id);

}
