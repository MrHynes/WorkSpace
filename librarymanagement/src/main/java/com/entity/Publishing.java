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
 * 出版社表实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午10:02:45
 */
@Entity
@Table(name = "t_publishing")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Publishing implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5421709006029890835L;
	private Integer id;
	// ISBN
	private String ISBN;
	// 出版社名称
	private String pubname;
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
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Column(length = 20)
	public String getPubname() {
		return pubname;
	}

	public void setPubname(String pubname) {
		this.pubname = pubname;
	}

	@OneToMany(mappedBy = "ISBN", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	public Set<BookInfo> getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(Set<BookInfo> bookInfo) {
		this.bookInfo = bookInfo;
	}

	public Publishing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Publishing(String iSBN, String pubname) {
		super();
		ISBN = iSBN;
		this.pubname = pubname;
	}

	@Override
	public String toString() {
		return "Publishing [id=" + id + ", ISBN=" + ISBN + ", pubname=" + pubname + "]";
	}

}
