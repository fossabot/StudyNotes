package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 从请求中获取数据
 * @author Administrator
 *
 */
public class ContextDemo4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//从请求中获取数据
		//String name = (String) servletContext.getAttribute("name");
		//System.out.println("name=>" + name);
		//强制类型转换
		Student student = (Student) servletContext.getAttribute("student");
		System.out.println(student);
	}
}
