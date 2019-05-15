package com.jp.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jp.po.Type;
import com.jp.po.TypeCustom;
import com.jp.service.TypeService;
import com.jp.utils.PageUtil;

@Controller
@RequestMapping("/type")
public class TypeController {

	@Autowired
	@Qualifier("typeService")
	private TypeService typeService;
	
	@RequestMapping("/toTypeList")
    public String toTypeList(Model model, @Param("pageNumNow")Integer pageNumNow) throws Exception{
	 	System.out.println("请求图书类型列表,页号:" + pageNumNow);
	 	//默认获取第一页
	 	int page = 1;
	 	//总页码数
	 	int pageNumTotal = typeService.getTypePagetotalNum();
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
	 	
        List<TypeCustom> typeList = typeService.getTypeListByPage(page, PageUtil.NumPerPageInBack);
        
        model.addAttribute("typeList" , typeList);
        
        return "back/book/book_type_list";
    }
	
	 //删除书籍
	 @RequestMapping("/deleteType")
	 public String deleteBook(@Param("id")String id) throws Exception{
		 
		System.out.println("删除图书类型---id：" + id);

		typeService.deleteTypeById(Integer.parseInt(id));
		 
		 return "forward:/type/toTypeList"; 
	 }
	 
	//添加类型
	 @RequestMapping("/addType")
	 public String addType(Model model) throws Exception{
	 
		System.out.println("添加图书类型信息请求");
		 
		return "back/book/book_type_add"; 
	 }
		 
	 //添加类型提交
	 @RequestMapping("/addTypeSubmit")
     public String addTypeSubmit(Type type, Model model) throws Exception{
			 
		System.out.println("添加图书类型信息提交---:"+type.getName());
		typeService.addType(type);
			
		return "forward:/type/toTypeList"; 
	 }
	 
	 //修改书籍
	 @RequestMapping("/modifyType")
	 public String modifyType(@Param("id")String id, Model model) throws Exception{
		 
		System.out.println("修改图书类型信息---id:" + id);
		Type type = typeService.getTypeById(Integer.parseInt(id));
		model.addAttribute("type", type);
		 
		 return "back/book/book_type_mod"; 
	 }
	 
	 //修改类型提交
	 @RequestMapping("/modifyTypeSubmit")
	 public String modifyTypeSubmit(Type type, Model model) throws Exception{
		 
		System.out.println("修改图书类型信息提交---:");
		typeService.modifyTypeById(type);
		 
		return "forward:/type/toTypeList"; 
	 }
	 /**
	  * 查询类型
	  * 根据 类型名 或 类型介绍 模糊查询
	  * @Description: TODO(这里用一句话描述这个方法的作用)   
	  * @param: @param model
	  * @param: @param name_desc
	  * @param: @return
	  * @param: @throws Exception      
	  * @return: String      
	  * @throws
	  */
	 @RequestMapping("/queryType")
	    public String queryType(Model model,@Param("name_desc")String name_desc) throws Exception{
		 	System.out.println("搜索图书类型:" + name_desc);
		 	
	        List<TypeCustom> typeList = typeService.getTypeList(name_desc);
	        
	        model.addAttribute("typeList" , typeList);
	        
	        return "back/book/book_type_list";
	    }
}
