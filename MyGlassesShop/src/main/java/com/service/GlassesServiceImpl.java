package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GlassesDao;
import com.entity.Glasses;

import util.Constant;

@Service("glassesService")
public class GlassesServiceImpl implements GlassesService{
	@Resource
	private GlassesDao glassesDao;
	@Override
	public List<Glasses> getAll() {
		// TODO Auto-generated method stub
		return glassesDao.getAll();
	}
	@Override
	public void save(Glasses glasses) {
		// TODO Auto-generated method stub
		glassesDao.save(glasses);
	}
	@Override
	public Map<String, Object> findGlassesByNowPage(int nowPage) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		List<Glasses> list = glassesDao.findByNowPage(nowPage);
		int totalRecord = glassesDao.findTotalRecord();
		int totalPage = (totalRecord+Constant.PAGE_SIZE-1)/Constant.PAGE_SIZE;
		
		map.put("glasses", list);
		map.put("totalPage", totalPage);
		return map;
	}
	@Override
	public void deleteByID(int nowId) {
		// TODO Auto-generated method stub
		glassesDao.deleteById(nowId);
	}
	@Override
	public Glasses findById(int id) {
		// TODO Auto-generated method stub
		return glassesDao.findById(id);
	}
	@Override
	public void updateById(Glasses glasses) {
		// TODO Auto-generated method stub
		glassesDao.updateById(glasses);
	}
	@Override
	public void updateGlasses(Glasses g) {
		// TODO Auto-generated method stub
		glassesDao.update(g);
	}
	@Override
	public List<Glasses> findByTypeId(int typeId) {
		// TODO Auto-generated method stub
		return glassesDao.findByTypeId(typeId);
	}
	@Override
	public List<Glasses> findPrice(int bottom, int top) {
		// TODO Auto-generated method stub
		return glassesDao.findPrice(bottom,top);
	}
	@Override
	public List<Glasses> findByBrandId(int brandId) {
		// TODO Auto-generated method stub
		return glassesDao.findByBrandId(brandId);
	}
	@Override
	public List<Glasses> findByMaterialId(int materialId) {
		// TODO Auto-generated method stub
		return glassesDao.findByMaterialId(materialId);
	}
	@Override
	public List<Glasses> findByColorId(int colorId) {
		// TODO Auto-generated method stub
		return glassesDao.findByColorId(colorId);
	}
	@Override
	public List<Glasses> findManGlasses() {
		// TODO Auto-generated method stub
		return glassesDao.findManGlasses();
	}
	@Override
	public List<Glasses> findWomenGlasses() {
		// TODO Auto-generated method stub
		return glassesDao.findWomenGlasses();
	}
}
