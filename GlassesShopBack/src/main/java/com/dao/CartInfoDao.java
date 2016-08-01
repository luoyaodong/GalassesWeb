package com.dao;

import java.util.List;

import com.entity.CartInfo;

public interface CartInfoDao {

	void save(CartInfo f);

	List<CartInfo> getInfoByCart(int id);

	void deleteCartInfo(int id, int infoId);

	CartInfo getInfoById(int id, int infoId);

	boolean checkInfo(int id, int id2);

}
