package com.jp.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.po.BookCustom;
import com.jp.service.BookService;
import com.jp.utils.PageUtil;

/**
 * 图书商店控制类
 * @ClassName:  BookStoreController   
 * @Description:TODO(Description)   
 * @author      ZJP
 * @date:2018年2月18日 下午8:13:01
 */
@Controller
@RequestMapping("/bookShop")
public class BookshopController {
	
	@Autowired
	@Qualifier("bookService")
	private BookService bookService;

	
	public BookshopController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping("/toBookList")
	private String toBookList(Model model,@Param("pageNumNow")Integer pageNumNow) throws Exception{
		
		System.out.println("前台请求图书列表,页号:" + pageNumNow);
	 	//默认获取第一页
	 	int page = 1;
	 	//总页码数
	 	int pageNumTotal = bookService.getBookPagetotalNum(PageUtil.NumPerPageInFront,null);
	 	//如果有指定页码
	 	if(pageNumNow!=null){
	 		page = pageNumNow>=1?pageNumNow:1;
	 		page = page>pageNumTotal?pageNumTotal:page;
	 	}
	 	
	 	//要显示的页码列表
	 	List<Integer> pageList = PageUtil.getPageNumList(page, pageNumTotal);
	 	model.addAttribute("pageNumTotal", pageNumTotal);  //总页书
	 	model.addAttribute("pageList", pageList);  //要显示的页码列表
	 	model.addAttribute("pageNumNow", page); //当前页码
	 	System.out.println(page+"/" +pageNumTotal);
	 	
        List<BookCustom> bookList = bookService.getBookListByPage(page, PageUtil.NumPerPageInFront,null);
        
        model.addAttribute("bookList" , bookList);
        
        //testOrderService();
        
		return "shop/book/list";
	}
	
	@RequestMapping("/getBookItems")
	 public String getBookItems(@Param("lsbn")String lsbn,Model model) throws Exception{
		 
		 System.out.println("前台获取图书详情：" + lsbn);
		 
		 BookCustom bookCustom = bookService.getBookByLsbn(lsbn);
		 model.addAttribute("book", bookCustom);
		 
		 return "shop/book/desc";
	 }
	
	//搜索书籍
	@RequestMapping("/queryBook")
	public String queryBook(@Param("lsbn_name_type")String lsbn_name_type,
			 				@Param("pageNumNow")Integer pageNumNow,Model model) throws Exception{
			 
		 System.out.println("前台搜索书籍:" + lsbn_name_type + "页码：" + pageNumNow);
		//默认获取第一页
		 int page = 1;
		 	//总页码数
		 int pageNumTotal = bookService.getBookPagetotalNumQuery(PageUtil.NumPerPageInFront,lsbn_name_type);
		 	//如果有指定页码
		 if(pageNumNow!=null){
		 	page = pageNumNow>=1?pageNumNow:1;
		 	page = page>pageNumTotal?pageNumTotal:page;
		 }
		 
		 //要显示的页码列表
		 List<Integer> pageList = PageUtil.getPageNumList(page, pageNumTotal);
		 model.addAttribute("pageNumTotal", pageNumTotal);  //总页书
		 model.addAttribute("pageList", pageList);  //要显示的页码列表
		 model.addAttribute("pageNumNow", page); //当前页码
		 model.addAttribute("lsbn_name_type", lsbn_name_type); //当前搜索框内容
		 List<BookCustom> bookList = bookService.queryBookByPage(page, PageUtil.NumPerPageInFront,lsbn_name_type);
		 model.addAttribute("bookList", bookList);
		 return "shop/book/list";
	 }
	
//	public void testOrderService() throws Exception{
//		System.out.println("测试orderservice");
//		List<OrderCustom> orderList = orderService.selectOrdersByUserid("1");
//		for(OrderCustom orderCustom:orderList){
//				System.out.println(orderCustom.getOrderid() + "-" +orderCustom.getOrdertime());
//				List<Book> bookList= orderCustom.getBookList();
//				System.out.println("该订单有"+bookList.size()+"本书籍");
//				for(Book book:bookList)
//					System.out.println(book.getName());
//		}
//	}

}
