package com.service;

import java.util.List;

import com.entity.GlassesMaterial;

public interface GlassesMaterialService {
	void save(GlassesMaterial material);

	List<GlassesMaterial> getAll();

	void deleteByMaterialId(int id);
}
