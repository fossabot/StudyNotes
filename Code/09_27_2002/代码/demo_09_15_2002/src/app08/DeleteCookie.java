package app08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除Cookie
 * @author Administrator
 *
 */
public class DeleteCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建cookie
		Cookie cookie = new Cookie("name", "xxxx");
		//删除同名cookie
		cookie.setMaxAge(0);
		//发送cookie对象到浏览器
		response.addCookie(cookie);
		System.out.println("删除成功...");
	}
}
