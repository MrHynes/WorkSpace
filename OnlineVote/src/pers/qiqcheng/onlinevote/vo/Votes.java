package pers.qiqcheng.onlinevote.vo;

public class Votes {
	private String id;
	private String name;
	private int num;

	public Votes(String id, String name, int num) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
