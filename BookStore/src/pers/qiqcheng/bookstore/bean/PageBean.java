package pers.qiqcheng.bookstore.bean;

import java.util.List;

public class PageBean {
	private List list;
	private int pageSize;//每页几条数据
	private int pageNo;//第几页
	private int totalRecord;//查询总记录数
	/**
	 * 查询总的页面数
	 */
	public int getTotalPages(){
		if(totalRecord%pageSize==0){
			return totalRecord/pageSize;
		}else {
			return totalRecord/pageSize+1;
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
	 * 取得尾页
	 * @return
	 */
	public int getBottonPage(){
		return getTotalPages();
	}
	/**
	 * 上一页
	 * @return
	 */
	public int getPreviousPage(){
		if(pageNo<=1)
			return 1;
		else {
			return pageNo-1;
		}
	}
	/**
	 * 下一页
	 * @return
	 */
	public int getNextPage(){
		if(pageNo>=getTotalPages()){
			return getTotalPages();
		}else {
			return pageNo+1;
		}
	}
	/**
	 * getter/setter方法
	 * @return
	 */
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
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
}
