package app04;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig对象
 * @author Administrator
 *
 */
public class ConfigDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//读取Servlet初始化参数
		//获取ServletConfig对象
		ServletConfig servletConfig = this.getServletConfig();
		//获取初始化参数
		String initParameter = servletConfig.getInitParameter("student");
		
	}
}
