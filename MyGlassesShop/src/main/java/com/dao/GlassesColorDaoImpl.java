package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.GlassesColor;

@Repository("glassesColorDao")
public class GlassesColorDaoImpl implements GlassesColorDao{
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void save(GlassesColor color) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(color);
	}
	@Override
	public List<GlassesColor> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from GlassesColor");
		return q.list();
	}
}
