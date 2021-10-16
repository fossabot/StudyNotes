package app02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet的生命周期
 * @author Administrator
 *
 */
public class LifeDemo extends HttpServlet {

	//1.加载和实例化
	public LifeDemo(){
		System.out.println("Servlet对象被创建了...");
	}
	
	//2.初始化
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init方法被调用...");
	}
	
	//3.处理请求
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service方法被调用...");
	}
	
	//4.销毁
	@Override
	public void destroy() {
		System.out.println("Servlet对象被销毁了...");
	}
}
