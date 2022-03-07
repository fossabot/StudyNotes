package app06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理get/post请求乱码
 * @author Administrator
 *
 */
public class RequestDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//指定每个请求的编码(post请求)  
		//request.setCharacterEncoding("utf-8");
		//获取请求数据
		String username = request.getParameter("username");
		//解决get请求的乱码
		username = new String(username.getBytes("iso-8859-1"), "utf-8");
		System.out.println("username=>" + username);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
