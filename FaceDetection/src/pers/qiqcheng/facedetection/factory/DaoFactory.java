package pers.qiqcheng.facedetection.factory;

import pers.qiqcheng.facedetection.dao.IFaceDetectionDao;
import pers.qiqcheng.facedetection.proxy.FaceDetectionDaoProxy;
/**
 * ������
 * @author Buer
 *
 */
public class DaoFactory {
	public static IFaceDetectionDao getFaceDetectionDaoInstance() throws Exception{
		return new FaceDetectionDaoProxy();
	}

}
