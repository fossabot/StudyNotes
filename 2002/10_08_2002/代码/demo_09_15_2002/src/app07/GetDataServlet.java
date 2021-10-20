package app07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取数据
 * @author Administrator
 *
 */
public class GetDataServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从request域对象中获取数据
		String name = (String) request.getAttribute("name");
		System.out.println("name=>" + name);
	}
}
