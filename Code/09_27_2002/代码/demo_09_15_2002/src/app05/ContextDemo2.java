package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取Web应用参数
 * @author Administrator
 *
 */
public class ContextDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//获取web应用参数
		String initParameter = servletContext.getInitParameter("student");
		System.out.println("参数：" + initParameter);
	}
}
