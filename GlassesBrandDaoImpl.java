package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.GlassesBrand;

@Repository("glassesBrandDao")
public class GlassesBrandDaoImpl implements GlassesBrandDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void save(GlassesBrand brand) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(brand);
	}

	@Override
	public List<GlassesBrand> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from GlassesBrand");
		return q.list();
	}

	@Override
	public void deleteByBrandId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from GlassesBrand b where b.id=:id");
		q.setInteger("id", id);
		GlassesBrand brand = (GlassesBrand) q.uniqueResult();
		session.delete(brand);
	}

}
