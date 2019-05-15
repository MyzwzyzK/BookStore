package com.jp.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.po.User;
import com.jp.service.UserService;



@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	/**
	 * 后台管理系统登陆
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param loginname
	 * @param: @param password
	 * @param: @param model
	 * @param: @param session
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/manageSystemLogin",
				method= RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	 public void manageSystemLogin(@RequestBody Map<String,Object> map,
			 		Model model,HttpSession session,PrintWriter pw) throws Exception{
		
		System.out.println("后台管理系统登陆请求......");
		boolean flag = false;
		String loginname = map.get("loginname").toString();
		String password = map.get("password").toString();
		System.out.println(loginname + "  " + password);
		User user = userService.login(loginname, password);
		if(user != null){
			System.out.println("登陆成功:" + user.getUsername() + " " + user.getIdentity());
			// 登录成功，将user对象设置到HttpSession作用范围域
			session.setAttribute("admin", user);
			session.setAttribute("identity", user.getIdentity());
			flag = true;
		}else{
			System.out.println("登录名或密码错误:" + loginname + "---" + password);
			flag = false;
		}
		Map<String,Object> mapout = new HashMap<String, Object>();
		mapout.put("flag", flag);
		System.out.println(flag);
		ObjectMapper om = new ObjectMapper();
		try{
			String jsonString = om.writeValueAsString(mapout);
			pw.write(jsonString);
			pw.flush();
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//后台管理系统退出登录
	 @RequestMapping(value="/manageSystemLoginOut")
	 public String manageSystemLoginOut(Model model,HttpSession session) throws Exception{
		
		System.out.println("后台管理系统退出登陆......");
		session.invalidate();
		return "login";
	}
	 //前台系统退出登录
	 @RequestMapping(value="/loginout")
	 public String loginout(Model model,HttpSession session) throws Exception{
		
		System.out.println("前台购书系统退出登陆......");
		session.invalidate();
		return "shop/login";
	}

	/**
	 * 处理前台login请求
	 * @throws Exception 
	 * */
	 @RequestMapping(value="/login",
				method = RequestMethod.POST, consumes = "application/json")
	 @ResponseBody
	 public void login(@RequestBody Map<String,Object> map,Model model,
			 		HttpSession session,PrintWriter pw) throws Exception{
		
		System.out.println("用户登陆请求......");
		boolean flag = false; //登录是否成功
		String loginname = map.get("loginname").toString();
		String password = map.get("password").toString();
		User user = userService.login(loginname, password);
		if(user != null){
			System.out.println("登陆成功:" + user);
			// 登录成功，将user对象设置到HttpSession作用范围域
			session.setAttribute("user", user);
			flag = true;
		}else{
			System.out.println("登录名或密码错误:" + loginname + "---" + password);
			// 登录失败，设置失败提示信息，并跳转到登录页面
			flag = false;
		}
		Map<String,Object> mapout = new HashMap<String, Object>();
		mapout.put("flag", flag);  //返回结果
		System.out.println(flag);
		ObjectMapper om = new ObjectMapper();
		try{
			String jsonString = om.writeValueAsString(mapout);
			pw.write(jsonString);
			pw.flush();
			pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 注册请求
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param loginname
	 * @param: @param password
	 * @param: @param model
	 * @param: @param session
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="/register",
			method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	 public void register(@RequestBody Map<String,Object> map,
			 Model model,HttpSession session,PrintWriter pw) throws Exception{
		
		System.out.println("用户注册请求......");
		String username = map.get("username").toString();
		String loginname= map.get("loginname").toString();
		String password = map.get("password").toString();
		System.out.println(username+" "+loginname+" "+password);
		boolean flag = userService.register(username, loginname, password);
		Map<String,Object> mapout=new HashMap<String,Object>();
		mapout.put("flag" , flag);
        System.out.println(flag);
        ObjectMapper om=new ObjectMapper();
        try{
            String jsonString =om.writeValueAsString(mapout);
            pw.write(jsonString);
            pw.flush();
            pw.close();
        }catch(JsonProcessingException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
	}
	
	@RequestMapping(value="/modifyPassword")
	 public String modifyPassword(HttpSession session,Model model) throws Exception{
		
		System.out.println("修改密码......");
		
		return "back/user/modifyPass";
	}
	
	@RequestMapping(value="/modifyPasswordSubmit")
	 public void modifyPasswordSubmit(String loginname,
			 		String password,String newPassword,PrintWriter pw) throws Exception{
		
		System.out.println("修改密码提交......");
		boolean flag=false;
        try{
            User user=userService.login(loginname , password);
            if(user!=null){
            	flag=userService.modifyPassword(loginname , newPassword);
            }else
            	flag = false;
        }catch(Exception e1){
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        if(flag)
        	System.out.println("用户 " + loginname+" 修改密码为：" + newPassword);
        else
        	System.out.println("密码输入错误，修改密码失败！");
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag" , flag);
        ObjectMapper om=new ObjectMapper();
        try{
            String jsonString =om.writeValueAsString(map);
            pw.write(jsonString);
            pw.flush();
            pw.close();
        }catch(JsonProcessingException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
	}
	
	@RequestMapping(value="/modifyPersonalInformation")
	 public String modifyPersonalInformation(HttpSession session,Model model) throws Exception{
		
		System.out.println("修改个人信息......");
		User user = (User)session.getAttribute("admin");
		User newUser = userService.getUserByLoginname(user.getLoginname());
		model.addAttribute("admin", newUser);
		return "back/user/modifyPersonalInformation";
	}
	
	@RequestMapping(value="/modifyPersonalInformationSubmit",
			method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	 public void modifyPersonalInformationSubmit(@RequestBody User user,HttpSession session,PrintWriter pw) throws Exception{
		
		System.out.println("修改个人信息提交......");
		boolean flag=false;
        try{
            flag=userService.modifyPersonalInformation(user);
        }catch(Exception e1){
            flag = false;
            e1.printStackTrace();
        }
//        if(flag){//修改保存在session中的信息
//        	User newUser = userService.getUserByLoginname(user.getLoginname());
//        	session.setAttribute("admin", newUser);
//        }
        System.out.println(flag);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("flag" , flag);
        ObjectMapper om=new ObjectMapper();
        try{
            String jsonString =om.writeValueAsString(map);
            pw.write(jsonString);
            pw.flush();
            pw.close();
        }catch(JsonProcessingException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
	}
	@RequestMapping(value="/toUserList")
	public String toUserList(Model model) throws Exception{
		//获取全部用户
		System.out.println("获取用户列表");
		List<User> userList = userService.getUserList(null);
		model.addAttribute("userList", userList);
		
		return "back/user/user_list";
	}
	
	@RequestMapping(value="/queryUser")
	public String queryUser(Model model,
				@Param("username_loginname")String username_loginname) throws Exception{
		//根据条件获取用户
		System.out.println("查询用户：" + username_loginname);
		List<User> userList = userService.getUserList(username_loginname);
		model.addAttribute("userList", userList);
		
		return "back/user/user_list";
	}
	
	//前台系统跳转到后台系统
	@RequestMapping(value="/frontToBack")
	public String frontToBack(Model model,HttpSession session){
		return "login";
	}
	//后台系统跳转到前台系统
	@RequestMapping(value="/backToFront")
	public String backToFront(Model model,HttpSession session){
		return "shop/login";
	}
	
	
}
