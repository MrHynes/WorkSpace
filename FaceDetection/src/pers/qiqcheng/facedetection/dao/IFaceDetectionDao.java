package pers.qiqcheng.facedetection.dao;

import java.sql.ResultSet;
import java.util.List;

public interface IFaceDetectionDao {
	/**
	 * 数据库查询、插入
	 * @param sql sql语句
	 * @param params 模糊查询参数
	 * @return
	 */
	public ResultSet doSelect(String sql,Object[] params);
	public boolean doInsert(String sql,Object[] params);
}
