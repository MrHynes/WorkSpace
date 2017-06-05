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
 * 读者类型实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午10:03:15
 */
@Entity
@Table(name = "t_readertype")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class ReaderType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5475427773307388830L;
	// id
	private Integer id;
	// 名称
	private String name;
	// 数量
	private Integer number;
	private Set<Reader> readerSet = new HashSet<Reader>();

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 4)
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	@OneToMany(mappedBy = "readerType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	public Set<Reader> getReaderSet() {
		return readerSet;
	}

	public void setReaderSet(Set<Reader> readerSet) {
		this.readerSet = readerSet;
	}

}
