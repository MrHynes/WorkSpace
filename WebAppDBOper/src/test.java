import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.dbop.dao.factory.DaoFactory;
import com.dbop.vo.Info;

public class test {
	public static void select(){
		ResultSet rs=null;
		//String sql="select * from info order by id";
		String sql="select * from info limit 0,10";
		try {
			rs = DaoFactory.getIDbopDaoInstance().doSelect(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getFloat(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		
		select();
	}

}
