package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 图书类型实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午9:21:43
 */
@Entity
@Table(name = "t_booktype")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class BookType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3098402313940758193L;
	// id
	private Integer id;
	// 类型名称
	private String typename;
	// 归还天数
	private Integer days;
	private Set<BookInfo> bookInfo = new HashSet<BookInfo>();

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30)
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	@Column
	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	@OneToMany(mappedBy = "booktype", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	public Set<BookInfo> getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(Set<BookInfo> bookInfo) {
		this.bookInfo = bookInfo;
	}

	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookType(String typename, Integer days) {
		super();
		this.typename = typename;
		this.days = days;
	}

	@Override
	public String toString() {
		return "BookType [id=" + id + ", typename=" + typename + ", days=" + days + "]";
	}

}
