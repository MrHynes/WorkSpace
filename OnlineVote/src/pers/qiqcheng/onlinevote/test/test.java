package pers.qiqcheng.onlinevote.test;


import java.sql.ResultSet;
import java.util.List;

import jdk.nashorn.internal.objects.annotations.Where;
import pers.qiqcheng.onlinevote.factory.DaoFactory;
import pers.qiqcheng.onlinevote.vo.Votes;

public class test {
	public static void main(String[] args) {
		String sql="insert into userinfo values(?,?)";
		String sql2="insert into voters values(?,?,?)";
		String sql3="select * from voters where id=?";
		String[] params={"201701"};
		boolean f=false;
		try {
			//f=DaoFactory.getVoteDaoInstance().doInsert(sql2, params);
			List<Votes> list=DaoFactory.getVoteDaoInstance().getVoters(sql3, params);
			for (Votes votes : list) {
				System.out.println(votes.getId()+" "+votes.getName()+" "+votes.getNum());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f){
			System.out.println("����ɹ�");
		}
		
	}
}
