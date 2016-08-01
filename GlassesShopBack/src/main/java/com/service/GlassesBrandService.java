package com.service;

import java.util.List;

import com.entity.GlassesBrand;

public interface GlassesBrandService {
	public void saveBrand(GlassesBrand Brand);

	public List<GlassesBrand> getAll();

	public void deleteByBrandId(int id);
}
