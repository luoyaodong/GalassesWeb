package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GlassesBrandDao;
import com.entity.GlassesBrand;
@Service("glassesBrandService")
public class GlassesBrandServiceImpl implements GlassesBrandService{
	
	@Resource
	private GlassesBrandDao brandDao;
	@Override
	public void saveBrand(GlassesBrand brand) {
		// TODO Auto-generated method stub
		brandDao.save(brand);
	}
	@Override
	public List<GlassesBrand> getAll() {
		// TODO Auto-generated method stub
		return brandDao.getAll();
	}
	@Override
	public void deleteByBrandId(int id) {
		// TODO Auto-generated method stub
		brandDao.deleteByBrandId(id);
	}

}
