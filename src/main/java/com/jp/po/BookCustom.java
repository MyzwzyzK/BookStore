package com.jp.po;

/**书的扩展类
 * 添加数量，用于表示在订单中每本书的数量
 * @ClassName:  BookCustom   
 * @Description:TODO(图书类的扩展类)   
 * @author      ZJP
 * @date:2018年2月3日 下午3:11:30
 */
public class BookCustom extends Book {
	
	private int num;//订单中书的数量
	
	public BookCustom() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	

}
