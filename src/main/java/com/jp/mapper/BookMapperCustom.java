package com.jp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jp.po.Book;
import com.jp.po.BookCustom;

public interface BookMapperCustom {
    /**
     * 根据用户
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @param identity
     * @param: @param userid
     * @param: @param startNum
     * @param: @param num
     * @param: @return
     * @param: @throws Exception      
     * @return: List<BookCustom>      
     * @throws
     */
	List<BookCustom> getBookListLimit(@Param("identity")String identity,
									@Param("userid")Integer userid,
									@Param("startNum")Integer startNum,
									@Param("num")Integer num) throws Exception;
	/**
	 * 根据查询条件
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param identity
	 * @param: @param lsbn_name_type
	 * @param: @param startNum
	 * @param: @param num
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<BookCustom>      
	 * @throws
	 */
	List<BookCustom> getBookListLimitQuery(@Param("lsbn_name_type")String lsbn_name_type,
			@Param("startNum")Integer startNum,
			@Param("num")Integer num) throws Exception;

	//获取书的总数量
	int getBookTotalCount(@Param("identity")String identity,
							@Param("userid")Integer userid) throws Exception;
	//获取书的总数量
	int getBookTotalCountQuery(@Param("lsbn_name_type")String lsbn_name_type) throws Exception;
	
	//根据lsbn编号，书名，或类型搜索
	List<BookCustom> queryBookList(@Param("value")String lsbn_name_type) throws Exception;
	
	Book selectByOrderid(@Param("orderid")String orderid) throws Exception;
}