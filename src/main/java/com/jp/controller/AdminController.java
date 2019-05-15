package com.jp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.po.Admin;
import com.jp.service.AdminService;
/**
 * 这里添加了一个注释，用于测试gitHub
 * @author Umbra
 *
 */


@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	@Qualifier("adminService")
	private AdminService adminService;

	/**
	 * 处理/login请求
	 * @throws Exception 
	 * */
	@RequestMapping(value="/login")
	 public String login(String loginname,String password,Model model,
			 HttpSession session) throws Exception{
		
		System.out.println("后台管理系统登陆请求......");
		Admin admin = adminService.login(loginname, password);
		if(admin != null){
			System.out.println("登陆成功:" + admin);
			// 登录成功，将user对象设置到HttpSession作用范围域
			session.setAttribute("admin", admin);

			return "main";
		}else{
			System.out.println("登录名或密码错误:" + loginname + "---" + password);
			// 登录失败，设置失败提示信息，并跳转到登录页面
			model.addAttribute("message", "登录名或密码错误，请重新输入!");
			return "login";
		}
	}
	
	
}
