package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CartDao;
import com.dao.CartInfoDao;
import com.entity.CartInfo;

@Service("cartInfoService")
public class CartInfoServiceImpl implements CartInfoService {
	@Resource
	private CartInfoDao cartInfoDao;

	@Override
	public void save(CartInfo f) {
		// TODO Auto-generated method stub
		cartInfoDao.save(f);
	}

	@Override
	public List<CartInfo> getInfoByCart(int id) {
		// TODO Auto-generated method stub
		return cartInfoDao.getInfoByCart(id);
	}

	@Override
	public void deleteCartInfo(int id, int infoId) {
		// TODO Auto-generated method stub
		cartInfoDao.deleteCartInfo(id,infoId);
	}

	@Override
	public boolean checkInfo(int id, int id2) {
		// TODO Auto-generated method stub
		return cartInfoDao.checkInfo(id,id2);
	}
}
