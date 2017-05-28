package pers.qiqcheng.ec.servlet.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AdminLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		Element element = null;
        //绝对路劲
        File f = new File("F://WorkSpace//ECProject//WebContent//WEB-INF//info.xml");
        // documentBuilder为抽象不能直接实例化(将XML文件转换为DOM文件)
        DocumentBuilder db = null;
        DocumentBuilderFactory dbf = null;
        try {
            // 返回documentBuilderFactory对象
            dbf = DocumentBuilderFactory.newInstance();
            // 返回db对象用documentBuilderFatory对象获得返回documentBuildr对象
            db = dbf.newDocumentBuilder();
            // 得到一个DOM并返回给document对象
            Document dt = db.parse(f);
            // 得到一个elment根元素
            element = dt.getDocumentElement();
            // 获得根节点
            //System.out.println("根元素：" + element.getNodeName());
            // 获得根元素下的子节点
            NodeList childNodes = element.getChildNodes();
            // 遍历这些子节点
            boolean flag=false;
            for (int i = 0; i < childNodes.getLength(); i++) {
                // 获得每个对应位置i的结点
                Node node1 = childNodes.item(i);
                if ("user".equals(node1.getNodeName())) {
                    // 获得下的节点
                    NodeList nodeDetail = node1.getChildNodes();
                    String XMLUserName=null;
                    String XMLPassWord=null;
                    // 遍历下的节点
                    for (int j = 0; j < nodeDetail.getLength(); j++) {
                        // 获得元素每一个节点
                        Node detail = nodeDetail.item(j);
                        if ("name".equals(detail.getNodeName())) // 输出code
                          XMLUserName=detail.getTextContent();
                        else if ("pwd".equals(detail.getNodeName())) // 输出pass
                          XMLPassWord=detail.getTextContent();
                    }
                    //判断xml中的获得的usernam和password和前端请求一起转发过来的是否匹配
                    if(username!=null&&password!=null&&XMLPassWord!=null&&XMLUserName!=null){
                    	if(username.equals(XMLUserName)&&password.equals(XMLPassWord)){
                    		session.setAttribute("adminName", username);
                    		flag=true;
                    		break;
                    	}
                    }
                }
            }
            if(flag){
            	req.getRequestDispatcher("/backend/index.jsp").forward(req, resp);
            }else{
            	resp.sendRedirect("http://localhost:8080/ECProject/common/error.jsp");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
