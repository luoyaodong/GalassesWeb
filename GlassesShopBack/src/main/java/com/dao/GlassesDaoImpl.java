package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.loader.plan.spi.QuerySpaceUidNotRegisteredException;
import org.hibernate.sql.Delete;
import org.springframework.stereotype.Repository;

import com.entity.Glasses;

import util.Constant;

@Repository("glassesDao")
public class GlassesDaoImpl implements GlassesDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Glasses> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses");
		List<Glasses> list = q.list();
		return list;
	}

	@Override
	public void save(Glasses glasses) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(glasses);
	}

	@Override
	public List<Glasses> findByNowPage(int nowPage) {
		// TODO Auto-generated method stub
		int begin = (nowPage - 1) * Constant.PAGE_SIZE;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses");
		q.setFirstResult(begin);
		q.setMaxResults(Constant.PAGE_SIZE);
		List<Glasses> list = q.list();
		return list;
	}

	@Override
	public int findTotalRecord() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses");
		List<Glasses> list = q.list();
		int num = list.size();
		return num + 1;
	}

	@Override
	public void deleteById(int nowId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(findById(nowId));
	}

	@Override
	public Glasses findById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.id=:id");
		q.setInteger("id", id);
		Glasses g = (Glasses) q.uniqueResult();
		return g;
	}

	@Override
	public void updateById(Glasses glasses) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(glasses);
	}

	@Override
	public void update(Glasses g) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(g);
	}

	@Override
	public List<Glasses> findByTypeId(int typeId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.type.id=:id");
		q.setInteger("id", typeId);
		return q.list();
	}

	@Override
	public List<Glasses> findPrice(int bottom, int top) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.price>=:bottom and g.price<=:top");
		q.setInteger("bottom", bottom);
		q.setInteger("top", top);
		return q.list();
	}

	@Override
	public List<Glasses> findByBrandId(int brandId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.brand.id=:brandId");
		q.setInteger("brandId", brandId);
		return q.list();
	}

	@Override
	public List<Glasses> findByMaterialId(int materialId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.material.id=:materialId");
		q.setInteger("materialId", materialId);
		return q.list();
	}

	@Override
	public List<Glasses> findByColorId(int colorId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.color.id=:colorId");
		q.setInteger("colorId", colorId);
		return q.list();
	}

	@Override
	public List<Glasses> findManGlasses() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.sex=:man");
		q.setString("man", "ÄÐ¿î");
		return q.list();
	}

	@Override
	public List<Glasses> findWomenGlasses() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.sex=:women");
		q.setString("women", "Å®¿î");
		return q.list();
	}

	@Override
	public void deleteByBrandId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("from Glasses g where g.brand.id=:id");
		q.setInteger("id", id);
		List<Glasses> glasses = q.list();
		for (Glasses glasses2 : glasses) {
			session.delete(glasses2);
		}
	}

	@Override
	public void deleteByColorId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("from Glasses g where g.color.id=:id");
		q.setInteger("id", id);
		List<Glasses> glasses = q.list();
		for (Glasses glasses2 : glasses) {
			session.delete(glasses2);
		}
	}

	@Override
	public void deleteByTypeId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.type.id=:id");
		q.setInteger("id", id);
		List<Glasses> glasses = q.list();
		for (Glasses glasses2 : glasses) {
			session.delete(glasses2);
		}
	}

	@Override
	public void deleteByMaterialId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Glasses g where g.material.id=:id");
		q.setInteger("id", id);
		List<Glasses> glasses = q.list();
		for (Glasses glasses2 : glasses) {
			session.delete(glasses2);
		}
	}
}
