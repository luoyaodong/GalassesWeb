package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.GlassesMaterial;

@Repository("glassesMaterialDao")
public class GlassesMaterialDaoImpl implements GlassesMaterialDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void save(GlassesMaterial material) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(material);
	}
	@Override
	public List<GlassesMaterial> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from GlassesMaterial");
		return q.list();
	}

}
