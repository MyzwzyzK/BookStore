package com.jp.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jp.po.BookCustom;
import com.jp.po.User;

public interface BookService {
	/**
	 * 
	 * @Description: TODO(通过页号获取图书列表)   
	 * @param: @param pageNum  页号
	 * @param: @param numPerPage 每页的数量
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<BookCustom>      
	 * @throws
	 */
	List<BookCustom> getBookListByPage(Integer pageNum,Integer numPerPage, User user) throws Exception;
	//获取书的总数量
	int getBookTotalCount(User user) throws Exception;
	//获取书的总数量
	int getBookTotalCountQuery(String lsbn_name_type) throws Exception;
	//获取书的页数
	int getBookPagetotalNum(int numPerPage,User user) throws Exception;
	//获取书的页数
	int getBookPagetotalNumQuery(int numPerPage,String lsbn_name_type) throws Exception;
	//添加书籍
	void addBook(BookCustom bookCustom,MultipartFile image, String imagePath) throws Exception;
	//删除书籍
	void deleteBooks(List<String> lsbnList) throws Exception;
	
	BookCustom getBookByLsbn(String lsbn) throws Exception;
	
	void modifyBook(BookCustom bookCustom) throws Exception;
	//根据lsbn编号，书名，或类型搜索
	List<BookCustom> queryBookByPage(Integer pageNum,Integer numPerPage,String lsbn_name_type) throws Exception;
}
