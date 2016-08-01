package com.dao;

import java.util.List;

import com.entity.GlassesType;

public interface GlassesTypeDao {

	void save(GlassesType type);

	List<GlassesType> getAll();

}
