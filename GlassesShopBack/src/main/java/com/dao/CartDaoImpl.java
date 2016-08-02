package com.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Cart;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void save(Cart c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(c);
	}
	
	public boolean findById(int id){
		boolean flag= true;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Cart c where c.id=:id");
		q.setInteger("id", id);
		if(q.list().isEmpty()){
			flag = false;
		}
		return flag;
	}
	@Override
	public void update(Cart c) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		if(findById(c.getId())){
			session.update(c);
		}else{
			session.save(c);
		}
	}
}
