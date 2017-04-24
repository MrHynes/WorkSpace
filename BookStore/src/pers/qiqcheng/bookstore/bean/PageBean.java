package pers.qiqcheng.bookstore.bean;

import java.util.List;

public class PageBean {
	private List list;
	private int pageSize;//ÿҳ��������
	private int pageNo;//�ڼ�ҳ
	private int totalRecord;//��ѯ�ܼ�¼��
	/**
	 * ��ѯ�ܵ�ҳ����
	 */
	public int getTotalPages(){
		if(totalRecord%pageSize==0){
			return totalRecord/pageSize;
		}else {
			return totalRecord/pageSize+1;
		}
	}
	/**
	 * ȡ����ҳ
	 * @return
	 */
	public int getTopPage(){
		return 1;
	}
	/**
	 * ȡ��βҳ
	 * @return
	 */
	public int getBottonPage(){
		return getTotalPages();
	}
	/**
	 * ��һҳ
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
	 * ��һҳ
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
	 * getter/setter����
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
