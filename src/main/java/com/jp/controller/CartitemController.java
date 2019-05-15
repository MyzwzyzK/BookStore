package com.jp.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.jp.po.CartDetails;
import com.jp.po.User;
import com.jp.service.CartItemService;

@Controller
@RequestMapping(value="/cartitem")
public class CartitemController {
	
	@Autowired
	@Qualifier("cartitemService")
	private CartItemService cartItemService;

	/**
	 * 购物车
	 * @throws Exception 
	 * */
	@RequestMapping(value="/getCartitem")
	 public String getCartitem(Model model,HttpSession session) throws Exception{
		
		System.out.println("获取购物车信息......");
		User user = (User)session.getAttribute("user");
		if(user!=null){
			System.out.println(user.getUserid());
			Integer userid = user.getUserid();
			List<CartDetails> itemList = cartItemService.getCartItemByUserId(userid);
			
			model.addAttribute("itemList",itemList);
			if(session.getAttribute("cartitemid")!=null)
				model.addAttribute("selectCartitemid",session.getAttribute("cartitemid").toString());
			else
				model.addAttribute("selectCartitemid",-1);
			session.setAttribute("selectCartitemid", null);
		}
		
		return "shop/cart/list";
	}
	
	@RequestMapping(value="/addToCart")
	public String addToCart(Model model,@Param("lsbn")String lsbn,
				@Param("num")Integer num,HttpSession session) throws Exception{
		System.out.println("加入购物车");
		User user = (User)session.getAttribute("user");
		if(user!=null){
			int userid = user.getUserid();
			System.out.println(lsbn+","+userid+","+num);
			cartItemService.addToCart(lsbn, userid, num);
			session.setAttribute("cartitemid", -1);  //跳转到购物车页面，不需要勾选
		}
		return "forward:/cartitem/getCartitem";
	}
	@RequestMapping(value="/purchase")
	public String purchase(Model model,@Param("lsbn")String lsbn,
				@Param("num")Integer num,HttpSession session) throws Exception{
		System.out.println("购买");
		User user = (User)session.getAttribute("user");
		if(user!=null){
			int userid = user.getUserid();
			System.out.println(lsbn+","+userid+","+num);
			int cartitemid = cartItemService.addToCart(lsbn, userid, num);
			System.out.println("插入主键："+cartitemid);
			session.setAttribute("cartitemid", cartitemid);  //跳转到购物车页面，刚添加的要勾选
		}
		return "forward:/cartitem/getCartitem";
	} 
	
	@RequestMapping(value="deleteCartitem")
	public String deleteCartitem(Model model,@Param("cartitemid")Integer cartitemid) throws Exception{
		System.out.println("删除购物车商品");
		System.out.println("cartitemid:" + cartitemid);
		cartItemService.deleteCartitemByCartitemid(cartitemid);
		
		return "forward:/cartitem/getCartitem";
	}
	
	@RequestMapping(value="batchDeleteCartitem")
	public String batchDeleteCartitem(Model model,@Param("cartitemids")String cartitemids) throws Exception{
		System.out.println("批量删除购物车商品");
		System.out.println("cartitemids:" + cartitemids);
		cartItemService.batchDeleteCartitem(cartitemids);
		return "forward:/cartitem/getCartitem";
	}
	
	@RequestMapping(value="/updateQuantity",
			method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	private void updateQuantity(Model model,HttpSession session,
			@RequestBody Map<String,Object> map,HttpServletRequest request,
			PrintWriter pw) throws Exception{
		
		System.out.println("更新购物车中图书数量");
		boolean flag = false;
		User user = (User)session.getAttribute("user");
		if(user!=null){
			int cartitemid = Integer.parseInt(map.get("cartitemid").toString());
			int quantity = Integer.parseInt(map.get("quantity").toString());
			System.out.println("cartitemid:" + cartitemid);
			System.out.println("Quantity:" + quantity);			
			flag = cartItemService.updateQuantity(cartitemid, quantity);
		}
		Map<String,Object> mapout=new HashMap<String,Object>();
		mapout.put("flag" , flag);
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
	}
}
