package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.CartInfo;

@Repository("cartInfoDao")
public class CartInfoImpl implements CartInfoDao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void save(CartInfo f) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(f);
	}

	@Override
	public List<CartInfo> getInfoByCart(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CartInfo f where f.cartId=:id");
		q.setInteger("id", id);
		return  q.list();
	}
	@Override
	public CartInfo getInfoById(int id,int infoId){
		Session session = sessionFactory.getCurrentSession();
		Query q  = session.createQuery("from CartInfo f where f.cartId=:cartId and f.infoId=:infoId");
		q.setInteger("cartId", id);
		q.setInteger("infoId", infoId);
		CartInfo info=(CartInfo) q.uniqueResult();
		return info;
	}

	@Override
	public void deleteCartInfo(int id, int infoId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CartInfo info = getInfoById(id, infoId);
		session.delete(info);
	}

	@Override
	public boolean checkInfo(int id, int id2) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CartInfo f where f.cartId=:cartId and f.infoId=:infoId");
		q.setInteger("cartId", id);
		q.setInteger("infoId", id2);
		return q.list().isEmpty();
	}
	
}
