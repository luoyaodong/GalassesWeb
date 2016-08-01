package com.service;

import java.util.List;
import java.util.Map;

import com.entity.User;

public interface UserService {
	public List<User> getAll();
	public void saveUser(User user);
	public boolean checkName(String name);
	public boolean checkLogin(String name, String pwd);
	public Map<String, Object> findUserByNowPage(int nowPage);
	public void deleteByID(int nowId);
	public User findUser(String name, String pwd);
	public User update(User user);
}
