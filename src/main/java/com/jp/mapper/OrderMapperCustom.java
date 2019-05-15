package com.jp.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jp.po.OrderCustom;


public interface OrderMapperCustom {
    /**
     * 根据订单号查询订单，支持模糊查询
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param orderid
     * @param: @return
     * @param: @throws Exception      
     * @return: OrderCustom      
     * @throws
     */
	public List<OrderCustom> selectByOrderid(@Param("orderid")String orderid) throws Exception;
	
	/**
	 * userid为空时获取全部数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<OrderCustom>      
	 * @throws
	 */
	public List<OrderCustom> selectOrdersByUserid(@Param("userid")Integer userid) throws Exception;
	
	/**
	 * 获取用户收到的订单
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<OrderCustom>      
	 * @throws
	 */
	public List<OrderCustom> selectOrdersReceiveByUserid(@Param("userid")Integer userid) throws Exception;
	/**
	 * 根据订单状态查询订单
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param status ，status为空时查询所有订单
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<OrderCustom>      
	 * @throws
	 */
	public List<OrderCustom> selectOrdersByStatus(@Param("status")String status) throws Exception;

}