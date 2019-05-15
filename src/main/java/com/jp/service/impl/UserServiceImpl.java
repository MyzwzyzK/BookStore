package com.jp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.mapper.UserMapper;
import com.jp.mapper.UserMapperCustom;
import com.jp.po.User;
import com.jp.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired 
	UserMapperCustom userMapperCustom;
	
	@Autowired 
	UserMapper userMapper;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User login(String loginname, String password) throws Exception {
		// TODO Auto-generated method stub
		return userMapperCustom.selectByLoginnameAndPassword(loginname, password);
	}

	@Override
	public boolean modifyPassword(String loginname, String newPassword) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = userMapperCustom.updatePasswordByLoginname(loginname, newPassword);
		return flag;
	}
	
	@Override
	/**
	 * 根据userid或username或loginname获取用户
	 * 条件： ==userid / like username /like loginname
	 * userid_username_loginname为空时获取全部用户
	 */
	public List<User> getUserList(String userid_username_loginname) throws Exception {
		// TODO Auto-generated method stub
		return userMapperCustom.getUserList(userid_username_loginname);
	}

	@Override
	public boolean register(String username, String loginname, String password) throws Exception {
		int num = userMapperCustom.selectByLoginname(loginname).size();
		System.out.println("num："+num);
		if(num>0){
			System.out.println("账号已存在！");
			return false;
		}else{
			User user = new User();
			user.setUsername(username);
			user.setLoginname(loginname);
			user.setPassword(password);
			return userMapper.insertSelective(user)>0?true:false;
		}
	}

	@Override
	public boolean modifyPersonalInformation(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(user)>0?true:false;
	}

	@Override
	public User getUserByLoginname(String loginname) throws Exception {
		// TODO Auto-generated method stub
		return userMapperCustom.selectByLoginname(loginname).get(0);
	}

}
