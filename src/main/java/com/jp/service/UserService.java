package com.jp.service;

import java.util.List;


import com.jp.po.User;

/**
 * @ClassName:  UserService   
 * @Description:TODO(用户管理类)   
 * @author      ZJP
 * @date:2018年3月27日 下午3:45:20
 */
public interface UserService {
	
	public User login(String loginname,String password) throws Exception;
	
	public User getUserByLoginname(String loginname) throws Exception;
	
	public boolean modifyPassword(String loginname,String newPassword) throws Exception;
	
	public boolean modifyPersonalInformation(User user) throws Exception;
	/**
	 * 根据userid或username或loginname获取用户
	 * 条件： ==userid / like username /like loginname
	 * userid_username_loginname为空时获取全部用户
	 */
	public List<User> getUserList(String userid_username_loginname) throws Exception;
	
	public boolean register(String username,String loginname,String password) throws Exception;
}
