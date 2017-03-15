package com.dbop.util;

import java.util.List;

public class PageBean {
	private List list;
	private int pageSize;//每页记录数
	private int pageNo;//第几页
	private int totalRecords;//记录总数
	/*
	 *计算总的页数 
	 */
	public int getTotalPages(){
		if(totalRecords%pageSize==0){
			return totalRecords/pageSize;	
		}
		else{
			return totalRecords/pageSize+1;	
		}
	}
	/**
	 * 取得首页
	 * @return
	 */
	public int getTopPage(){
		return 1;
	}
	/**
	 * 取得上一页
	 * @return 
	 * @return
	 */
	public int getPreviousPage(){
		if(pageNo<0){
			return 1;
		}
		return pageNo-1;
	}
	/**
	 * 取得下一页
	 * @return
	 */
	public int getNextPage(){
		if(pageNo>getTotalPages()){
			return getTotalPages();
		}else{
			return pageNo+1;
		}
	}
	/**
	 * 取得尾页
	 * @return
	 */
	public int getBottomPage(){
		return getTotalPages();
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	

}
