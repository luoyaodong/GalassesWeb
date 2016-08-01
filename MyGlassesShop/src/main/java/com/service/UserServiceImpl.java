package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.Glasses;
import com.entity.User;

import util.Constant;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		list = userDao.getAll();
		return list;
	}
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		return userDao.checkName(name);
	}

	@Override
	public boolean checkLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		return userDao.checkLogin(name,pwd);
	}

	@Override
	public Map<String, Object> findUserByNowPage(int nowPage) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		List<Glasses> list = userDao.findByNowPage(nowPage);
		int totalRecord = userDao.findTotalRecord();
		int totalPage = (totalRecord+Constant.PAGE_SIZE-1)/Constant.PAGE_SIZE;
		
		map.put("user", list);
		map.put("totalPage", totalPage);
		return map;
	}

	@Override
	public void deleteByID(int nowId) {
		// TODO Auto-generated method stub
		userDao.deleteById(nowId);
	}

	@Override
	public User findUser(String name, String pwd) {
		// TODO Auto-generated method stub
		return userDao.findUser(name,pwd);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}
}
