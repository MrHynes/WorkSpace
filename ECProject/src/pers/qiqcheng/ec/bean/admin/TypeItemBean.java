package pers.qiqcheng.ec.bean.admin;

public class TypeItemBean {
	private Integer typeID;
	private String typeName;
	public Integer getTypeID() {
		return typeID;
	}
	public void setTypeID(Integer typeID) {
		this.typeID = typeID;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	@Override
	public String toString() {
		return "TypeItemBean [typeID=" + typeID + ", typeName=" + typeName + "]";
	}
	

}
