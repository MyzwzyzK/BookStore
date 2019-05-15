package com.jp.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jp.mapper.BookMapper;
import com.jp.mapper.BookMapperCustom;
import com.jp.po.Book;
import com.jp.po.BookCustom;
import com.jp.po.User;
import com.jp.service.BookService;
import com.jp.utils.ImageUtils;

@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookMapperCustom bookMapperCustom;
	@Autowired
	private BookMapper bookMapper;
	
	@Override
	public List<BookCustom> getBookListByPage(Integer pageNum, Integer numPerPage, User user) throws Exception {
		//根据页号和每页数量计算起始点
		int startNum = numPerPage*(pageNum-1);
		if(user==null){
			user = new User();
			user.setIdentity("admin");
			user.setUserid(0);
		}
		return bookMapperCustom.getBookListLimit(user.getIdentity(),user.getUserid(),
												startNum, numPerPage);
	}

	@Override
	public int getBookTotalCount(User user) throws Exception {
		// TODO Auto-generated method stub
		if(user==null){
			user = new User();
			user.setIdentity("admin");
			user.setUserid(0);
		}
		return bookMapperCustom.getBookTotalCount(user.getIdentity(),user.getUserid());
	}
	@Override
	public int getBookTotalCountQuery(String lsbn_name_type) throws Exception {
		// TODO Auto-generated method stub
		return bookMapperCustom.getBookTotalCountQuery(lsbn_name_type);
	}

	@Override
	public int getBookPagetotalNum(int numPerPage,User user) throws Exception {
		// TODO Auto-generated method stub
		 int total = this.getBookTotalCount(user);
		 if(total%numPerPage==0){
			 return total/numPerPage; 
		 }else{
			 return total/numPerPage + 1;
		 }
	}
	@Override
	public int getBookPagetotalNumQuery(int numPerPage, String lsbn_name_type) throws Exception {
		// TODO Auto-generated method stub
		int total = this.getBookTotalCountQuery(lsbn_name_type);
		 if(total%numPerPage==0){
			 return total/numPerPage; 
		 }else{
			 return total/numPerPage + 1;
		 }
	}

	@Override
	public void addBook(BookCustom bookCustom, MultipartFile image, String imagePath) throws Exception {
		//两种尺寸的图片
		String imageBName = bookCustom.getLsbn().substring(0, 10) + "_b.jpg";
		String imageBPath = imagePath + File.separator + imageBName;
		String imageWName = bookCustom.getLsbn().substring(0, 10) + "_w.jpg";;
		String imageWPath = imagePath + File.separator + imageWName;
		//保存图片
		if(!image.isEmpty()){			
			//上传文件名
			String filename = image.getOriginalFilename();
			String name = bookCustom.getLsbn().substring(0, 10) + "." + filename.substring(filename.lastIndexOf(".") + 1); 
			System.out.println("文件保存路径:" + imagePath);
			System.out.println("文件名:" + name); 
			File filepath = new File(imagePath,filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			String imageS = imagePath+File.separator + filename;
			image.transferTo(new File(imageS));
			//改变图片大小
			ImageUtils.resizeImage_JPG(imageS, imageBPath, 200, 200);
			ImageUtils.resizeImage_JPG(imageS, imageWPath, 350, 350);
//			bookCustom.setImageB("book_img/" + imageBName);
//			bookCustom.setImageB("book_img/" + imageWName);
			bookCustom.setImageb(imageBName);
			bookCustom.setImagew(imageWName);
		}
		
		bookMapper.insertSelective(bookCustom);
	}

	@Override
	public void deleteBooks(List<String> lsbnList) throws Exception {
		for(String lsbn:lsbnList){
			Book book = bookMapper.selectByPrimaryKey(lsbn);
			ImageUtils.deleteBookImage(book.getImageb());
			ImageUtils.deleteBookImage(book.getImagew());
			bookMapper.deleteByPrimaryKey(lsbn);
		}
		
	}

	@Override
	public BookCustom getBookByLsbn(String lsbn) throws Exception {
		Book book = bookMapper.selectByPrimaryKey(lsbn);
		BookCustom bookCustom = new BookCustom();
		BeanUtils.copyProperties(book, bookCustom);
		return bookCustom;
	}

	@Override
	public void modifyBook(BookCustom bookCustom) throws Exception {
		bookMapper.updateByPrimaryKeySelective(bookCustom);
		
	}

	@Override
	public List<BookCustom> queryBookByPage(Integer pageNum, Integer numPerPage, String lsbn_name_type)
			throws Exception {
		int startNum = numPerPage*(pageNum-1);
		return bookMapperCustom.getBookListLimitQuery(lsbn_name_type, startNum, numPerPage);
	}
	
	
//	public void fun() {
//		try {
//			List<BookCustom> bookList = bookMapperCustom.getBookListLimit(0, bookMapperCustom.getBookTotalCount());
//			for(BookCustom bookCustom : bookList){
//				if(bookCustom.getDescription()==null||bookCustom.getDescription()==""){
//					bookCustom.setDescription("无");
//					bookMapper.updateByPrimaryKeySelective(bookCustom);
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}


}

