package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Image;
@Repository("imageDao")
public class ImageDaoImpl implements ImageDao {
	@Resource
	private SessionFactory sessionFactory;
	@Override
	public void save(Image image) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(image);
	}
	@Override
	public List<Image> getImageByUserId(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Image g where g.user.id=:id");
		q.setInteger("id", id);
		return q.list();
	}
	@Override
	public String findName(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("select max(image.id) from Image as image");
		int i = (int) q.uniqueResult();
		Image image = findImageById(i);
		return image.getBigImg();
	}
	public Image findImageById(int id){
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Image img where img.id=:id");
		q.setInteger("id", id);
		Image image = (Image) q.uniqueResult();
		return image;
	}

}
