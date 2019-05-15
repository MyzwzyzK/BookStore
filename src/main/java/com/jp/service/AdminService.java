package com.jp.service;

import com.jp.po.Admin;

/**
 * @ClassName:  AdminService   
 * @Description:TODO(管理员)(无用)   
 * @author      ZJP
 * @date:2018年2月3日 下午2:22:31
 */
public interface AdminService {
	
	public Admin login(String loginname, String password) throws Exception;
}
