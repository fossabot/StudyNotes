package app07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求转发与重定向
 * @author Administrator
 *
 */
public class ForwardDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向request中保存数据
		request.setAttribute("name", "yingjian");
		//请求转发
		request.getRequestDispatcher("/GetDataServlet").forward(request, response);
	}
}
