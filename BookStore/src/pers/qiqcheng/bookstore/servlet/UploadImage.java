package pers.qiqcheng.bookstore.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadImage extends HttpServlet {

	/**
	 * ͷ���ϴ�
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String username=(String)session.getAttribute("username");
		String filePath=this.getServletContext().getRealPath("/image");
		File file=new File(filePath);
		//���Ŀ¼�����ڣ����½�һ����
		if(!file.exists()&&!file.isDirectory()){
			//����Ŀ¼
			file.mkdir();
		}
		//ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
		//1������һ��DiskFileItemFactory����
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//2������һ���ļ��ϴ�������
		ServletFileUpload upload=new ServletFileUpload(factory);
		//����ϴ��ļ�������������
		upload.setHeaderEncoding("utf-8");
		//3���ж��ύ�����������Ƿ����ϴ���������
		if(!ServletFileUpload.isMultipartContent(req)){
			return;
		}
		//4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
		List<FileItem> list;
		try {
			list = upload.parseRequest(req);
			for (FileItem item : list) {
				//���fileitem�з�װ������ͨ�����������
				if(item.isFormField()){
					String name=item.getFieldName();
					//�����ͨ����������ݵ�������������
					String value=item.getString("UTF-8");
				}else{//���fileitem�з�װ�����ϴ��ļ�
					String filename = item.getName();//�õ��ϴ����ļ����ƣ�
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					//�����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					InputStream in = item.getInputStream();//��ȡitem�е��ϴ��ļ���������
					//����һ���ļ������
					FileOutputStream out = new FileOutputStream(filePath + "\\" + username+".jpg");
					byte buffer[] = new byte[1024];//����һ��������
					//�ж��������е������Ƿ��Ѿ�����ı�ʶ
					int len = 0;
					while((len=in.read(buffer))>0){
						//ʹ��FileOutputStream�������������������д�뵽ָ����Ŀ¼(savePath + "\\" + filename)����
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					//ɾ�������ļ��ϴ�ʱ���ɵ���ʱ�ļ�
					item.delete();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("userInfo.jsp").forward(req,resp);
	}
}
