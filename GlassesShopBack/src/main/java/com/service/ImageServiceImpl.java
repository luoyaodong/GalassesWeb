package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ImageDao;
import com.entity.Image;

@Service("imageService")
public class ImageServiceImpl implements ImageService {
	
	@Resource
	private ImageDao imageDao;
	@Override
	public void save(Image image) {
		// TODO Auto-generated method stub
		imageDao.save(image);
	}
	@Override
	public List<Image> getImageByUserId(int id) {
		// TODO Auto-generated method stub
		return imageDao.getImageByUserId(id);
	}
	@Override
	public String findName(int id) {
		// TODO Auto-generated method stub
		return imageDao.findName(id);
	}

}
