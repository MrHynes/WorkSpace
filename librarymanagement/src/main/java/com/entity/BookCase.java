package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 书架位置表实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午10:01:25
 */
@Entity
@Table(name = "t_bookcase")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class BookCase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4915471228382370423L;
	// 书架Id
	private Integer id;
	// 具体位置
	private String name;
	private BookInfo bookInfo;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookCase(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@OneToOne(mappedBy = "bookcase")
	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	@Override
	public String toString() {
		return "BookCase [id=" + id + ", name=" + name + "]";
	}

}
