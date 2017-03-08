import java.util.List;

import com.dbop.dao.factory.DaoFactory;
import com.dbop.vo.Info;

public class test {
	public static void select(){
		List<Info> list=null;
		try {
			list = DaoFactory.getIDbopDaoInstance().doSelect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Info info : list) {
			System.out.println(info.getId()+" "+info.getName()+" "+info.getAge()+" "+info.getScore());
		}
	}
	public static void delete(){
		boolean flag=false;
		try {
			flag=DaoFactory.getIDbopDaoInstance().doDelete("105032014005");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			System.out.println("删除成功");
			select();
		}
	}
	public static void update(){
		Info info=new Info("105032014002","cxh",20,90.4f);
		boolean flag=false;
		try {
			flag=DaoFactory.getIDbopDaoInstance().doUpdate(info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag){
			System.out.println("更新成功");
			select();
		}
	}
	public static void main(String[] args) {
		
		
		update();
	}

}
