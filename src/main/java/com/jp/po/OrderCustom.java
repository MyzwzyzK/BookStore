package com.jp.po;

import java.util.List;

public class OrderCustom extends Orders {
	
	private List<BookCustom> bookList;
	
	public OrderCustom() {
		// TODO Auto-generated constructor stub
	}

	public List<BookCustom> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookCustom> bookList) {
		this.bookList = bookList;
	}
	

}
