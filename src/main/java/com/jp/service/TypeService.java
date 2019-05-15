package com.jp.service;

import java.util.List;

import com.jp.po.Type;
import com.jp.po.TypeCustom;

public interface TypeService {
	
	List<TypeCustom> getTypeList(String name_descripton) throws Exception;
	
	List<TypeCustom> getTypeListByPage(Integer pageNum,Integer numPerPage) throws Exception;
	//获取书的总数量
	int getTypeTotalCount() throws Exception;
	//获取书的页数
	int getTypePagetotalNum() throws Exception;
	
	void deleteTypeById(Integer id) throws Exception;
	
	Type getTypeById(Integer id) throws Exception;
	
	void modifyTypeById(Type type) throws Exception;
	
	void addType(Type type) throws Exception;
	

}
