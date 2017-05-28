package pers.qiqcheng.ec.bean.admin;

import java.util.List;

public class TypeBean {
	private Integer typeID;
	private String typeName;
	private List<TypeItemBean> items=null;
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public List<TypeItemBean> getItems() {
		return items;
	}
	public void setItems(List<TypeItemBean> items) {
		this.items = items;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "TypeBean [typeID=" + typeID + ", typeName=" + typeName + ", items=" + items.toString() + "]";
	}
	
}
