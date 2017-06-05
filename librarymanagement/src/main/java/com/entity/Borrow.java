package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 借阅表实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午9:26:23
 */
@Entity
@Table(name = "t_borrow")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Borrow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// id
	private Integer id;
	// 读者Id
	private Reader reader;
	// 图书Id
	private BookInfo bookInfo;
	// 借阅时间
	private Date borrowTime;
	// 归还时间
	private Date backTime;
	// 操作者
	private String operator;
	// 是否归还
	private boolean ifback;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	@JoinColumn(name = "readerid")
	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	@OneToOne
	@JoinColumn(name = "bookid")
	public BookInfo getBookid() {
		return bookInfo;
	}

	public void setBookid(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	@Column
	public Date getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}

	@Column
	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	@Column(length = 30)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column
	public boolean isIfback() {
		return ifback;
	}

	public void setIfback(boolean ifback) {
		this.ifback = ifback;
	}

}
