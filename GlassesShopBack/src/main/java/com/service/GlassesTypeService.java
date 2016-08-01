package com.service;

import java.util.List;

import com.entity.GlassesType;

public interface GlassesTypeService {
	public void saveType(GlassesType type);

	public List<GlassesType> getAll();

	public void deleteByTypeId(int id);
}
