package pers.qiqcheng.bookstore.bean;

public class BookCartBean {
	private String bookName;
	private float price;
	private String press;
	private String author;
	private String isbn;
	private int num;
	public BookCartBean() {
		super();
	}
	public BookCartBean(String bookName, float price, String press, String author, String isbn,int num) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.press = press;
		this.author = author;
		this.isbn = isbn;
		this.num=num;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public float getSum(){
		return this.num*this.price;
	}
	
}
