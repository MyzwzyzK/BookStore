package com.jp.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
	//后台显示每页数据量
	public static int NumPerPageInBack = 8;
	//书店页面每页数量
	public static int NumPerPageInFront = 28;
	//页面选择处可跳转的范围
	private static int PageSelectRange = 5;
	/**
	 * @Description: TODO(获取在页面中可选择的跳转页面的页号)   
	 * @param: @param pageNumNow
	 * @param: @param pageNumTotal
	 * @param: @return      
	 * @return: List<Integer>      
	 * @throws
	 */
	public static List<Integer> getPageNumList(int pageNumNow, int pageNumTotal){
		List<Integer> numList = new ArrayList<Integer>();
		
		int start = 1>(pageNumNow-PageSelectRange/2)?1:(pageNumNow-PageSelectRange/2);
		int end = (start+PageSelectRange)<pageNumTotal?(start+PageSelectRange):pageNumTotal;
		
		for(int i=start;i<=end;i++){
			numList.add(i);
		}
		return numList;
	}

}
