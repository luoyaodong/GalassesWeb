package com.dao;

import java.util.List;

import com.entity.GlassesMaterial;

public interface GlassesMaterialDao {

	void save(GlassesMaterial material);

	List<GlassesMaterial> getAll();

}
