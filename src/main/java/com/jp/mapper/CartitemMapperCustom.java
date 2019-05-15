package com.jp.mapper;

import com.jp.po.CartDetails;
import com.jp.po.Cartitem;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CartitemMapperCustom {
    
	public List<CartDetails> getByUserId(@Param("userid")Integer userid) throws Exception;
	
	public List<CartDetails> getByCartitemid(@Param("cartitemid")String[] cartitemid) throws Exception;
	
	public int insert(Cartitem record) throws Exception;
	
	public Cartitem selectByLsbn(@Param("lsbn")String lsbn) throws Exception;
}