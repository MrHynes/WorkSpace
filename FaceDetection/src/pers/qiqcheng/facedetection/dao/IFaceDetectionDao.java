package pers.qiqcheng.facedetection.dao;

import java.sql.ResultSet;
import java.util.List;

public interface IFaceDetectionDao {
	/**
	 * ���ݿ��ѯ������
	 * @param sql sql���
	 * @param params ģ����ѯ����
	 * @return
	 */
	public ResultSet doSelect(String sql,Object[] params);
	public boolean doInsert(String sql,Object[] params);
}
