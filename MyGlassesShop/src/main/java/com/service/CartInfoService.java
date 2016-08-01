package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.CartInfo;


public interface CartInfoService {

	void save(CartInfo f);

	List<CartInfo> getInfoByCart(int id);

	void deleteCartInfo(int id, int infoId);

	boolean checkInfo(int id, int id2);

}
