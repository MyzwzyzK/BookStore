package com.jp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jp.mapper.OrderMapperCustom;
import com.jp.mapper.OrderitemMapper;
import com.jp.mapper.OrdersMapper;
import com.jp.po.CartDetails;
import com.jp.po.OrderCustom;
import com.jp.po.Orderitem;
import com.jp.po.Orders;
import com.jp.po.User;
import com.jp.service.OrderService;


@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderMapperCustom orderMapperCustom;
	
	@Autowired
	OrdersMapper orderMapper;
	
	@Autowired
	OrderitemMapper orderitemMapper;
	
	public OrderServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
     * 根据订单号查询订单，支持模糊查询
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param orderid
     * @param: @return
     * @param: @throws Exception      
     * @return: OrderCustom      
     * @throws
     */
	public List<OrderCustom> selectByOrderid(String orderid) throws Exception {
		// TODO Auto-generated method stub
		return orderMapperCustom.selectByOrderid(orderid);
	}
	@Override
	/**
	 * userid为空时获取全部数据
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param userid
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<OrderCustom>      
	 * @throws
	 */
	public List<OrderCustom> selectOrdersByUser(User user) throws Exception {
		// TODO Auto-generated method stub
		if(user.getIdentity().equals("admin"))
			return orderMapperCustom.selectOrdersByUserid(null);
		else
			return orderMapperCustom.selectOrdersByUserid(user.getUserid());
	}

	@Override
	public void createNewOrder(Orders order, List<CartDetails> cartDetailslist) throws Exception {
		orderMapper.insertSelective(order);
		for(CartDetails cartDetails:cartDetailslist){
			Orderitem item = new Orderitem();
			item.setOrderid(order.getOrderid());
			item.setLsbn(cartDetails.getLsbn());
			item.setNum(cartDetails.getNum());
			orderitemMapper.insert(item);
		}
	}

	@Override
	/**
	 * 获取用户收到的订单
	 */
	public List<OrderCustom> selectOrdersReceiveByUserid(Integer userid) throws Exception {
		// TODO Auto-generated method stub
		return orderMapperCustom.selectOrdersReceiveByUserid(userid);
	}

	@Override
	public boolean updateStatus(Integer id, String status) throws Exception {
		// TODO Auto-generated method stub
		Orders order = new Orders();
		order.setId(id);
		order.setStatus(status);
		return orderMapper.updateByPrimaryKeySelective(order)>0?true:false;
	}

	@Override
	/**
	 * 根据订单状态查询订单
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param status ，status为全部时查询所有订单
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<OrderCustom>      
	 * @throws
	 */
	public List<OrderCustom> selectOrdersByStatus(String status) throws Exception {
		if(status.equals("全部"))
			return orderMapperCustom.selectOrdersByStatus(null);
		else
			return orderMapperCustom.selectOrdersByStatus(status);
	}

}
