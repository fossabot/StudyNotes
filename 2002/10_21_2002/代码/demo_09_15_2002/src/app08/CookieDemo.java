package app08;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie技术
 * @author Administrator
 *
 */
public class CookieDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建Cookie对象
		Cookie cookie = new Cookie("name", "mingxin");
		//设置Cookie有效时间，单位：秒
		//cookie.setMaxAge(20);
		cookie.setMaxAge(-1);
		//cookie.setMaxAge(0);
		//将cookie发送到浏览器中
		response.addCookie(cookie);
		//接收浏览器发送的cookie
		Cookie[] cookies = request.getCookies();
		//判断数组是否为空
		if(null!=cookies){
			//遍历cookie数组
			for (Cookie c : cookies) {
				//获取cookie的名称
				String name = c.getName();
				//获取cookie的值
				String value = c.getValue();
				System.out.println(name + "=" + value);
			}
		}else{
			System.out.println("没有接收到cookie数据...");
		}
	}
}
