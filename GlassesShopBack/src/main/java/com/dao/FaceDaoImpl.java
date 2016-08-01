package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Face;

@Repository("faceDao")
public class FaceDaoImpl implements FaceDao {
	@Resource
	 private SessionFactory sessionFactory;

	@Override
	public List<Face> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Face");
		return q.list();
	}
}
