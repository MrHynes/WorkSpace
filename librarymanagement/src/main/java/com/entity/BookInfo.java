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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 图书信息实体类
 * 
 * @description:TODO
 * @author:Allen Walker
 * @time:2017年5月31日 上午9:13:56
 */
@Entity
@Table(name = "t_bookinfo")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler", "fieldHandler" })
public class BookInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// id
	private Integer id;
	// 条形码
	private String barcode;
	// 图书名称
	private String bookname;
	// 类型id
	private BookType booktype;
	// 作者
	private String author;
	// 翻译者
	private String translator;
	// ISNB
	private Publishing ISBN;
	// 单价
	private float price;
	// 页数
	private Integer page;
	// 书架位置id
	private BookCase bookcase;
	//
	private Date intime;
	// 操作者
	private String operator;
	//
	private boolean del;

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 30)
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	@Column(length = 70)
	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "typeid")
	public BookType getBooktype() {
		return booktype;
	}

	public void setBooktype(BookType booktype) {
		this.booktype = booktype;
	}

	@Column(length = 30)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(length = 30)
	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ISBN")
	public Publishing getISBN() {
		return ISBN;
	}

	public void setISBN(Publishing iSBN) {
		ISBN = iSBN;
	}

	@Column
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	@OneToOne
	@JoinColumn(name = "bookcaseId")
	public BookCase getBookcase() {
		return bookcase;
	}

	public void setBookcase(BookCase bookcase) {
		this.bookcase = bookcase;
	}

	@Column
	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	@Column(length = 30)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column
	public boolean isDel() {
		return del;
	}

	public void setDel(boolean del) {
		this.del = del;
	}

	public BookInfo() {
		super();
	}

	public BookInfo(Integer id, String barcode, String bookname, String author, String translator, float price,
			Integer page, String operator, boolean del) {
		super();
		this.id = id;
		this.barcode = barcode;
		this.bookname = bookname;
		this.author = author;
		this.translator = translator;
		this.price = price;
		this.page = page;

		this.operator = operator;
		this.del = del;
	}

	@Override
	public String toString() {
		return "BookInfo [id=" + id + ", barcode=" + barcode + ", bookname=" + bookname + ", booktype=" + booktype
				+ ", author=" + author + ", translator=" + translator + ", ISBN=" + ISBN + ", price=" + price
				+ ", page=" + page + ", bookcase=" + bookcase + ", intime=" + intime + ", operator=" + operator
				+ ", del=" + del + "]";
	}

}
