package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GlassesMaterialDao;
import com.entity.GlassesMaterial;

@Service("glassesMaterialService")
public class GlassesMaterialServiceImpl implements GlassesMaterialService {
	@Resource
	private GlassesMaterialDao glassesMaterialDao;

	@Override
	public void save(GlassesMaterial material) {
		// TODO Auto-generated method stub
		glassesMaterialDao.save(material);
	}

	@Override
	public List<GlassesMaterial> getAll() {
		// TODO Auto-generated method stub
		return glassesMaterialDao.getAll();
	}

	@Override
	public void deleteByMaterialId(int id) {
		// TODO Auto-generated method stub
		glassesMaterialDao.deleteByMaterialId(id);
	}
}
