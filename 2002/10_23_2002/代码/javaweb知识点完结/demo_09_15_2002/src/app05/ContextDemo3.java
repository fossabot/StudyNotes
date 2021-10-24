package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 向请求中保存数据
 * @author Administrator
 *
 */
public class ContextDemo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取域对象（ServletContext）
		ServletContext servletContext = this.getServletContext();
		//将数据保存在域对象中
		//servletContext.setAttribute("name", "yiming");
		servletContext.setAttribute("student", new Student("yanze", 20));
		System.out.println("保存成功...");
	}
}
