

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

/*	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		out.println("<html><head><title>hello servlet</title></head><body>hello world!!</body></html>");
		out.flush();
		out.close();
	}*/
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost");
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("doget");
	    resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		out.println("<html><head><title>hello servlet</title></head><body>��ã�hello world!!</body></html>");
		out.flush();
		out.close();
	}
}
