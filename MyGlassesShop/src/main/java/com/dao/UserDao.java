package com.dao;

import com.entity.Glasses;
import com.entity.User;

import java.util.List;

/**
 * 对User实体�?映射的表的crud操作
 * Created by dengry on 2016/4/6.
 */
public interface UserDao {
    List<User> getAll();
    void save(User user);
	boolean checkName(String name);
	boolean checkLogin(String name, String pwd);
	List<Glasses> findByNowPage(int nowPage);
	int findTotalRecord();
	void deleteById(int nowId);
	User findById(int id);
	User findUser(String name, String pwd);
	User update(User user);
}
