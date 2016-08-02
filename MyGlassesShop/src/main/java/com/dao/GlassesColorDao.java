package com.dao;

import java.util.List;

import com.entity.GlassesColor;

public interface GlassesColorDao {

	void save(GlassesColor color);

	List<GlassesColor> getAll();

}
