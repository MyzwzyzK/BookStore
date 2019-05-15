package com.jp.service;

import java.util.List;

import com.jp.po.CartDetails;

public interface CartItemService {
	
	public List<CartDetails> getCartItemByUserId(Integer userid) throws Exception;
	
	public List<CartDetails> getCartItemByCartitemid(String[] cartitemid) throws Exception;
	
	public int addToCart(String lsbn,int userid,int num) throws Exception;
	
	public void deleteCartitemByCartitemid(Integer cartitemid) throws Exception;
	
	public void batchDeleteCartitem(String cartitemids) throws Exception;
	
	public boolean updateQuantity(Integer cartitemid,Integer num) throws Exception;
}
