package com.jp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.mapper.AdminMapperCustom;
import com.jp.po.Admin;
import com.jp.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapperCustom adminMapperCustom;

	@Override
	public Admin login(String loginname, String password) throws Exception {
		// TODO Auto-generated method stub
		return adminMapperCustom.selectByLoginnameAndPassword(loginname, password);
	}

}
