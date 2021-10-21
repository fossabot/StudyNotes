package app09;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 删除session
 * @author Administrator
 *
 */
public class DeleteSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前session
		HttpSession session = request.getSession(false);
		//判断是否存在当前session
		if(null!=session){
			//移除session中存储的数据
			session.removeAttribute("name");
			//手动销毁session
			session.invalidate();
		}
		System.out.println("销毁成功...");
	}
}
