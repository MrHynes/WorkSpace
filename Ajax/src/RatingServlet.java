
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class RatingServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// 创建jsonObject
		JSONObject jsonObject = JSONObject.fromObject(jsonString(request));
		String rating = jsonObject.getString("rating");
		String comm = jsonObject.getString("comm");
		System.out.println("rating="+rating+"\ncomm="+comm);
		int rate = Integer.parseInt(rating);
		String result = "\"您的评分是"+rating+"<br>"+"Comment:"+comm;
		
		switch(rate) {
			
		case 5:
			result += "<br>您对这门课程非常感兴趣,祝你成功！\"";
			break;
		case 4:
			result +="<br>您对这门课程很感兴趣，请加油！\"";
			break;
		case 3:
			result +="<br>您对这门课程有些兴趣，要坚持！\"";
			break;	
		case 2:
				result +="<br>别泄气，你会喜欢这门课程的！\"";
				break;
		case 1:
			result +="<br>很遗憾！\"";
			break;
		
		
		}
		response.setHeader("cache-control", "no-cache");
		response.setHeader("pragma","no-cache");
		response.setHeader("content-type","application/json;charset=utf-8");
		
		JSONObject json = JSONObject.fromObject( "{\"result\":"+result+"}" );
		PrintWriter out = response.getWriter();
		out.println(json);
		out.flush();
		out.close();
		
		
		
		
	}
	
	public String jsonString(HttpServletRequest request)throws IOException {
		
		// 先将 jsonString 读出来
		BufferedReader br = request.getReader();       
		String line = null;       
		StringBuilder jsonBuffer = new StringBuilder();  
		while ((line = br.readLine()) != null) {   
			jsonBuffer.append(line);        
		} 
		// 创建jsonObject
		
		
		return jsonBuffer.toString() ;
		
		
	}

}
