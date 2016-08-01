package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CartDao;
import com.entity.Cart;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Resource
	private CartDao cartDao;
	@Override
	public void save(Cart c) {
		// TODO Auto-generated method stub
		cartDao.save(c);
	}
	@Override
	public void update(Cart c) {
		// TODO Auto-generated method stub
		cartDao.update(c);
	}

}
