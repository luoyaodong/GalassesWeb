package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.GlassesType;

@Repository("glassesTypeDao")
public class GlassesTypeDaoImpl implements GlassesTypeDao {
	@Resource
    private SessionFactory sessionFactory;
	@Override
	public void save(GlassesType type) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(type);
	}
	@Override
	public List<GlassesType> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from GlassesType");
		return q.list();
	}

}
