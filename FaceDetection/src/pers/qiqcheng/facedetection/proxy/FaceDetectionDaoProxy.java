package pers.qiqcheng.facedetection.proxy;

import java.sql.ResultSet;
import java.util.List;

import pers.qiqcheng.facedetection.dao.IFaceDetectionDao;
import pers.qiqcheng.facedetection.dao.impl.FaceDetectionDaoImp;
import pers.qiqcheng.facedetection.dbc.DBConnection;
/**
 * 代理类
 * @author Buer
 *
 */
public class FaceDetectionDaoProxy implements IFaceDetectionDao{
	private DBConnection conn=null;
	private IFaceDetectionDao dao=null;
	public FaceDetectionDaoProxy() throws Exception {
		this.conn=new DBConnection();
		this.dao=new FaceDetectionDaoImp(this.conn.getConnection());
	}

	/**
	 * 执行数据库查询操作
	 */
	@Override
	public ResultSet doSelect(String sql, Object[] params) {
		ResultSet rs=null;
		rs=this.dao.doSelect(sql, params);
		return rs;
	}
	@Override
	/**
	 * 数据插入操作
	 */
	public boolean doInsert(String sql, Object[] params) {
		boolean flag=false;
		flag=this.dao.doInsert(sql, params);
		this.conn.close();
		return flag;
	}

}
