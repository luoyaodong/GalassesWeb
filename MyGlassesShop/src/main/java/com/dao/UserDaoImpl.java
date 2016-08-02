package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Glasses;
import com.entity.User;

import util.Constant;

/**
 * Created by dengry on 2016/4/6.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        List<User> users = query.list();
        return users;
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User u where u.name=:name");
		q.setString("name", name);
		if(q.list().isEmpty()){
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean checkLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User u where u.name=:name and u.pwd=:pwd");
		q.setString("name",name);
		q.setString("pwd", pwd);
		if(q.list().isEmpty()){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<Glasses> findByNowPage(int nowPage) {
		// TODO Auto-generated method stub
		int begin = (nowPage - 1) * Constant.PAGE_SIZE;
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User");
		q.setFirstResult(begin);
		q.setMaxResults(Constant.PAGE_SIZE);
		List<Glasses> list = q.list();
		return list;
	}

	@Override
	public int findTotalRecord() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User");
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
	public User findById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User u where u.id=:id");
		q.setLong("id", id);
		User u = (User) q.uniqueResult();
		return u;
	}

	@Override
	public User findUser(String name, String pwd) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query q=session.createQuery("from User u where u.name=:name and u.pwd=:pwd");
		q.setString("name", name);
		q.setString("pwd", pwd);
		User user =(User) q.uniqueResult();
		return user;
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
		return findById(user.getId());
	}

}
