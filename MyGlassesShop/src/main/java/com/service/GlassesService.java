package com.service;

import java.util.List;
import java.util.Map;

import com.entity.Glasses;

public interface GlassesService {
	List<Glasses> getAll();
	public void save(Glasses glasses);
	Map<String,Object> findGlassesByNowPage(int nowPage);
	void deleteByID(int nowId);
	Glasses findById(int id);
	void updateById(Glasses glasses);
	void updateGlasses(Glasses g);
	List<Glasses> findByTypeId(int typeId);
	List<Glasses> findPrice(int bottom, int top);
	List<Glasses> findByBrandId(int brandId);
	List<Glasses> findByMaterialId(int materialId);
	List<Glasses> findByColorId(int colorId);
	List<Glasses> findManGlasses();
	List<Glasses> findWomenGlasses();
}
