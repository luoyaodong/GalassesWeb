package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GlassesTypeDao;
import com.entity.GlassesType;

@Service("glassesTypeService")
public class GlassesTypeServiceImpl implements GlassesTypeService {
	@Resource
	private GlassesTypeDao glassesTypeDao;

	@Override
	public void saveType(GlassesType type) {
		// TODO Auto-generated method stub
		glassesTypeDao.save(type);
	}

	@Override
	public List<GlassesType> getAll() {
		// TODO Auto-generated method stub
		return glassesTypeDao.getAll();
	}
	
}
