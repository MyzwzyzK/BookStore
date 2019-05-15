package com.jp.po;

import java.util.List;

public class Test {

	private List<CartDetails> itemlist;
	private String address;
	private String total;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public List<CartDetails> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<CartDetails> itemlist) {
		this.itemlist = itemlist;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Test [itemlist=" + itemlist + ", address=" + address + ", total=" + total + "]";
	}

}
