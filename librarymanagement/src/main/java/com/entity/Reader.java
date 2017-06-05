package com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 读者实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午10:03:04
 */
@Entity
@Table(name = "t_reader")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Reader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -637495763673970591L;
	// id
	private Integer id;
	// 名称
	private String name;
	// 性别
	private String sex;
	// 读者ID(唯一标识)
	private String barcode;
	// 职业
	private String vocation;
	// 出生日期
	private Date birthday;
	// 证件类型
	private String paperType;
	// 证件号
	private String paperNo;
	// 联系电话
	private String tel;
	// 邮箱
	private String email;
	// 创建日期
	private Date createDate;
	// 操作者
	private String operator;
	// remark
	private String remark;
	// 读者类型
	private ReaderType readerType;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 4)
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(length = 30)
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Column(length = 50)
	public String getVocation() {
		return vocation;
	}

	public void setVocation(String vocation) {
		this.vocation = vocation;
	}

	@Column
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(length = 10)
	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	@Column(length = 20)
	public String getPaperNo() {
		return paperNo;
	}

	public void setPaperNo(String paperNo) {
		this.paperNo = paperNo;
	}

	@Column(length = 20)
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(length = 30)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(columnDefinition = "TEXT")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "typeid")
	public ReaderType getReaderType() {
		return readerType;
	}

	public void setReaderType(ReaderType readerType) {
		this.readerType = readerType;
	}

}
