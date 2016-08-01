package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Comments;
@Repository("commentsDao")
public class CommentsDaoImpl implements CommentsDao {
	
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void save(Comments comment) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(comment);
	}
	@Override
	public List<Comments> findByGlasseId(int id) {
		// TODO Auto-generated method stubse
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Comments t where t.glassesId=:id");
		q.setInteger("id", id);
		List<Comments> c = q.list();
		return c;
	}

}
