package pers.qiqcheng.spring.demo05;

import java.util.List;
import java.util.Map;


public class CollectionBean {
	private List<String> list;
	private Map<String,Car> map;
	
	public CollectionBean() {
		super();
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void setMap(Map<String,Car> map) {
		this.map = map;
	}
	@Override
	public String toString() {
		return "CollectionBean [list=" + list + ", map=" + map + "]";
	}
	

}
