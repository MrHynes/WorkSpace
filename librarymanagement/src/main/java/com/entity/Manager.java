package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 管理员实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午10:02:25
 */
@Entity
@Table(name = "t_manager")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4665642411944927729L;
	// id
	private Integer id;
	// 名称
	private String name;
	// 密码
	private String PWD;

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

	@Column(length = 30)
	public String getPWD() {
		return PWD;
	}

	public void setPWD(String pWD) {
		PWD = pWD;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", PWD=" + PWD + "]";
	}

}
