package com.jp.service;

import java.util.List;



import com.jp.po.CartDetails;
import com.jp.po.OrderCustom;
import com.jp.po.Orders;
import com.jp.po.User;

public interface OrderService {
	/**
     * 根据订单号查询订单，支持模糊查询
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param orderid
     * @param: @return
     * @param: @throws Exception      
     * @return: OrderCustom      
     * @throws
     */
	public List<OrderCustom> selectByOrderid(String orderid) throws Exception;
	
	public List<OrderCustom> selectOrdersByUser(User user) throws Exception;
	
	public void createNewOrder(Orders order,List<CartDetails> cartDetailslist) throws Exception;
	
	public List<OrderCustom> selectOrdersReceiveByUserid(Integer userid) throws Exception;
	
	public boolean updateStatus(Integer id,String status) throws Exception;
	/**
	 * 根据订单状态查询订单
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param status ，status为全部时查询所有订单
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<OrderCustom>      
	 * @throws
	 */
	public List<OrderCustom> selectOrdersByStatus(String status) throws Exception;
}
