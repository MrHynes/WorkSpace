package pers.qiqcheng.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 编码过滤器
 * 将应用的编码设置为web.xml中配置的编码方式
 * @author Buer
 *
 */
public class EncodingFilter implements Filter{

	private FilterConfig config;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config=filterConfig;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		String encode=config.getInitParameter("encode");
		if(encode!=null&&!encode.isEmpty()){
			req.setCharacterEncoding(encode);
		}
		chain.doFilter(req, resp);
		if(encode!=null&&!encode.isEmpty()){
			resp.setCharacterEncoding(encode);
		}
		
	}
	@Override
	public void destroy() {
		
	}

}
