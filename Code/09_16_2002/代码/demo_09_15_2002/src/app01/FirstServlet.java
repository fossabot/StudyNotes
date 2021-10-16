package app01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 第一个Servlet程序
 * @author Administrator
 *
 */
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向浏览器中输出内容,获取打印流对象
		PrintWriter pw = response.getWriter();
		//输出内容
		pw.write("this is first servlet");
		//刷新缓冲区
		pw.flush();
		//关闭资源
		pw.close();
	}
}
