package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.FaceDao;
import com.entity.Face;
@Service("faceService")
public class FaceServiceImpl implements FaceService {
	@Resource
	private FaceDao faceDao;
	@Override
	public List<Face> getAll() {
		// TODO Auto-generated method stub
		return faceDao.getAll();
	}

}
