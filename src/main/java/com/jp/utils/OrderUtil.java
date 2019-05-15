package com.jp.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderUtil {

	private static List<String> orderStatusList = new ArrayList<String>();
	
	static{
		orderStatusList.add("未付款");
		orderStatusList.add("已发货");
		orderStatusList.add("等待确认");
		orderStatusList.add("交易成功");
		orderStatusList.add("已取消");
	};
	
	public OrderUtil() {
	}
	/**
	 * 生成不重复的订单号
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String createOrderId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	public static List<String> getOrderStatusList() {
		return orderStatusList;
	}
	public static void setOrderStatusList(List<String> orderStatusList) {
		OrderUtil.orderStatusList = orderStatusList;
	}

	
	
}
