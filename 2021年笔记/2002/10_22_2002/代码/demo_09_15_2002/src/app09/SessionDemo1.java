package app09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Session技术
 * @author Administrator
 *
 */
public class SessionDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建session对象
		HttpSession session = request.getSession();
		//获取sessionid
		System.out.println("id=" + session.getId());
		//设置session有效时间 单位为秒
		//session.setMaxInactiveInterval(20);
		//向session中保存数据
		session.setAttribute("name", "xiaoyu");
	}
}
