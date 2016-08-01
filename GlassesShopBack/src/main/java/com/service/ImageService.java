package com.service;

import java.util.List;

import com.entity.Image;

public interface ImageService {

	void save(Image image);

	List<Image> getImageByUserId(int id);

	String findName(int id);

}
