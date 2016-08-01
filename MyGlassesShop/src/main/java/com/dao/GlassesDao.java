package com.dao;

import java.util.List;

import com.entity.Glasses;

public interface GlassesDao {
	List<Glasses> getAll();
	public void save(Glasses glasses);
	List<Glasses> findByNowPage(int nowPage);
	int findTotalRecord();
	void deleteById(int nowId);
	Glasses findById(int id);
	void updateById(Glasses glasses);
	void update(Glasses g);
	List<Glasses> findByTypeId(int typeId);
	List<Glasses> findPrice(int bottom, int top);
	List<Glasses> findByBrandId(int brandId);
	List<Glasses> findByMaterialId(int materialId);
	List<Glasses> findByColorId(int colorId);
	List<Glasses> findManGlasses();
	List<Glasses> findWomenGlasses();
}
