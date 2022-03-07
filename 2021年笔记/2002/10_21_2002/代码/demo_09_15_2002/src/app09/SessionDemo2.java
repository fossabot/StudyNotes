package app09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 获取数据
 * @author Administrator
 *
 */
public class SessionDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取(当前)session
		HttpSession session = request.getSession(false);
		//判断是否存在当前session
		if(null==session){
			System.out.println("没有找到当前session...");
			return;
		}
		System.out.println("id=" + session.getId());
		//获取数据
		String name = (String) session.getAttribute("name");
		System.out.println("name=" + name);
	}
}
