package com.uploadfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class UploadFile extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		System.out.println(username+"12");
		String filePath=this.getServletContext().getRealPath("/image");
		File file=new File(filePath);
		if(!file.exists()&&!file.isDirectory()){
			System.out.println("目录不存在");
			file.mkdir();
		}
		String message="";
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		if(!ServletFileUpload.isMultipartContent(req)){
			System.out.println("1");
			return;
		}
		List<FileItem> list;
		try {
			list = upload.parseRequest(req);
			System.out.println(list+"2");
			for (FileItem item : list) {
				if(item.isFormField()){
					String name=item.getFieldName();
					String value=item.getString("UTF-8");
				}else{
					String filename = item.getName();
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(filePath + "\\" + username+".jpg");
					byte buffer[] = new byte[1024];
					int len = 0;
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					message = "文件上传成功！";
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("message",message);
		req.getRequestDispatcher("/JSP/fileUpLoad/imageUpLoad.jsp").forward(req,resp);
	}

}
