package com.jp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jp.po.TypeCustom;

public interface TypeMapperCustom {
    
	List<TypeCustom> getTypeList(@Param("value")String name_description)throws Exception;
	
	List<TypeCustom> getTypeListLimit(@Param("startNum")Integer startNum,
			@Param("num")Integer num) throws Exception;

	//获取书的总数量
	int getTypeTotalCount() throws Exception;
	
	
}