package com.service;

import java.util.List;

import com.entity.GlassesColor;

public interface GlassesColorService {
	void save(GlassesColor color);

	List<GlassesColor> getAll();
}
