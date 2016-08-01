package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.GlassesBrand;

public interface GlassesBrandDao {
	public void save(GlassesBrand brand);

	public List<GlassesBrand> getAll();
}
