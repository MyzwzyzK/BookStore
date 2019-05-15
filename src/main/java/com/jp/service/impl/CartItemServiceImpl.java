package com.jp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.mapper.CartitemMapper;
import com.jp.mapper.CartitemMapperCustom;
import com.jp.po.CartDetails;
import com.jp.po.Cartitem;
import com.jp.service.CartItemService;

@Service("cartitemService")
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	CartitemMapperCustom cartitemMapperCustom;
	@Autowired
	CartitemMapper cartitemMapper;
	public CartItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CartDetails> getCartItemByUserId(Integer userid) throws Exception {
		// TODO Auto-generated method stub
		return cartitemMapperCustom.getByUserId(userid);
	}

	@Override
	public int addToCart(String lsbn, int userid, int num) throws Exception {
		//
		Cartitem cartitem = cartitemMapperCustom.selectByLsbn(lsbn);
		if(cartitem!=null){
			cartitem.setNum(cartitem.getNum()+num);
			cartitemMapper.updateByPrimaryKeySelective(cartitem);
			return cartitem.getCartitemid();
		}else{
		cartitem = new Cartitem();
		cartitem.setLsbn(lsbn);
		cartitem.setUserid(userid);
		cartitem.setNum(num);
		cartitemMapperCustom.insert(cartitem);
		return cartitem.getCartitemid();//返回插入后的主键
		}
	}

	@Override
	public void deleteCartitemByCartitemid(Integer cartitemid) throws Exception {
		cartitemMapper.deleteByPrimaryKey(cartitemid);
	}

	@Override
	public void batchDeleteCartitem(String cartitemids) throws Exception {
		String[] ids = cartitemids.split(",");
		for(String id:ids)
			deleteCartitemByCartitemid(Integer.parseInt(id));
	}

	@Override
	public List<CartDetails> getCartItemByCartitemid(String[] cartitemid) throws Exception {
		// TODO Auto-generated method stub
		return cartitemMapperCustom.getByCartitemid(cartitemid);
	}

	@Override
	/**
	 * 修改购物车中图书数量
	 */
	public boolean updateQuantity(Integer cartitemid, Integer num) throws Exception {
		// TODO Auto-generated method stub
		if(num==0)
			return cartitemMapper.deleteByPrimaryKey(cartitemid)>0?true:false;
		else{
			Cartitem cartitem = new Cartitem();
			cartitem.setCartitemid(cartitemid);
			cartitem.setNum(num);
			return cartitemMapper.updateByPrimaryKeySelective(cartitem)>0?true:false;
		}
	}

}
