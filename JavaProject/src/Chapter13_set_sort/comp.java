package Chapter13_set_sort;

import java.util.Comparator;

public class comp implements Comparator<student> {

	public int compare(student o1, student o2) {
		// TODO Auto-generated method stub
		if(o1.getAge()>o2.getAge()){
			return 1;
		}else if(o1.getAge()<o2.getAge()){
			return -1;
		}else{
			return 0;
		}
	}

}
