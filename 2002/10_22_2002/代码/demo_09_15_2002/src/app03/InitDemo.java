package app03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * init()方法
 * @author Administrator
 *
 */
public class InitDemo extends HttpServlet {

	//Servlet生命周期方法
	/*@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("有参数的init()方法...");
	}*/
	
	//无参的init()方法
	@Override
	public void init() throws ServletException {
		System.out.println("无参的init()方法...");
	}
}
