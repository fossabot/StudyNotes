package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext对象获取Web应用路径
 * @author Administrator
 *
 */
public class ContextDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		//方式1:通过ServletConfig对象获取
		//ServletContext servletContext = this.getServletConfig().getServletContext();
		//方式二：使用当前对象获取ServletContext对象（推荐使用）
		ServletContext servletContext = this.getServletContext();
		//获取Web应用路径
		String contextPath = servletContext.getContextPath();
		System.out.println("web应用路径为：" + contextPath);
		//重定向
		//response.sendRedirect("/demo_09_15_2002" + "/01_index.jsp");
		//推荐使用
		response.sendRedirect(request.getContextPath() + "/01_index.jsp");
	}
}
