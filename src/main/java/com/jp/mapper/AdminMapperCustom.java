package com.jp.mapper;

import com.jp.po.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminMapperCustom {
    
	public Admin selectByLoginnameAndPassword(@Param("loginname")String loginname,
											@Param("password")String password) throws Exception;
}