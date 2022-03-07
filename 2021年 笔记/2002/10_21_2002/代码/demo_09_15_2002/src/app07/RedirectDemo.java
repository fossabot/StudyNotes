package app07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向
 * @author Administrator
 *
 */
public class RedirectDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向request对象中保存数据
		request.setAttribute("name", "gaoyan");
		//重定向
		//response.sendRedirect(request.getContextPath() + "/GetDataServlet");
		//重定向到外部资源（其他Web应用）
		response.sendRedirect("/test_2002/index.html");
	}
}
