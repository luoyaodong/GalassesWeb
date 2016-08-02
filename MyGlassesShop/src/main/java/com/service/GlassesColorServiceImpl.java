package com.service;
 
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GlassesColorDao;
import com.entity.GlassesColor;

@Service("glassesColorService")
public class GlassesColorServiceImpl implements GlassesColorService{
	@Resource
	private GlassesColorDao glassesColorDao;
	
	@Override
	public void save(GlassesColor color) {
		// TODO Auto-generated method stub
		glassesColorDao.save(color);
	}

	@Override
	public List<GlassesColor> getAll() {
		// TODO Auto-generated method stub
		return glassesColorDao.getAll();
	}

}
