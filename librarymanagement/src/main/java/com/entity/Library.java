package com.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 图书馆表实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午10:02:09
 */
@Entity
@Table(name = "t_library")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Library implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3736888972476682807L;
	// id
	private Integer id;
	// 图书馆名称
	private String libraryname;
	// 管理人
	private String curator;
	// 联系电话
	private String tel;
	// 地址
	private String address;
	// 邮箱
	private String email;
	// url
	private String url;
	// 创建日期
	private Date createDate;
	// 介绍
	private String introduce;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 50)
	public String getLibraryname() {
		return libraryname;
	}

	public void setLibraryname(String libraryname) {
		this.libraryname = libraryname;
	}

	@Column(length = 10)
	public String getCurator() {
		return curator;
	}

	public void setCurator(String curator) {
		this.curator = curator;
	}

	@Column(length = 20)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 100)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(columnDefinition = "text")
	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Library(Integer id, String libraryname, String curator, String tel, String address, String email, String url,
			Date createDate, String introduce) {
		super();
		this.id = id;
		this.libraryname = libraryname;
		this.curator = curator;
		this.tel = tel;
		this.address = address;
		this.email = email;
		this.url = url;
		this.createDate = createDate;
		this.introduce = introduce;
	}

}
