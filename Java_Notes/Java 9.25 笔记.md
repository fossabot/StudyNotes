# 9月25日笔记 2002 56节

## 1.回顾 [[Java 9.24 笔记]]

1. get请求与post请求乱码
   1. 了解get/post请求区别
   2. 了解常见的字符集编码
   3. 处理post请求乱码，解决方案是设置请求的字符集编码
   4. 处理get请求乱码
      1. 治标方法：new String(username.getByes("iso-8859-1"),"utf-8");
      2. 治本方法：设置tomcat/conf/server.xml文件中第71行

## 2.Servlet

> 如何处理发送到浏览器操作的编码？

```java
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
		//设置响应在编码
		response.setContentType("text/html;charset=utf-8");
		//向浏览器中输出内容,获取打印流对象
		PrintWriter pw = response.getWriter();
		//输出内容
		//pw.write("this is first servlet");
		pw.write("继达");
		//刷新缓冲区
		pw.flush();
		//关闭资源
		pw.close();
	}
}
```

**请求转发与重定向**

请求转发与重定向的区别

| 比较项       | 转发        | 重定向  |
| ------------ | ----------- | ------- |
| URL变化      | 否          | 是      |
| 重新发出请求 | 不会        | 会      |
| 是否携带请求 | 是          | 否      |
| 目标URL要求  | 仅本Web应用 | 任意URL |

<font color="red">注：请求转发为服务器行为，而重定向为客户端行为</font>

```java
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
```

```java
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
```

```java
package app07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向
 * @author Administrator
 *
 */
public class RedirectDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向request对象中保存数据
		request.setAttribute("name", "gaoyan");
		//重定向
		response.sendRedirect(request.getContextPath() + "/GetDataServlet");
	}
}
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>demo_09_15_2002</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  
  <!-- 配置web应用参数 -->
  <context-param>
  	<param-name>student</param-name>
  	<param-value>guojun</param-value>
  </context-param>
  
  <!-- 配置Servlet -->
  <servlet>
  	<servlet-name>FirstServlet</servlet-name>
  	<servlet-class>app01.FirstServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>FirstServlet</servlet-name>
  	<url-pattern>/FirstServlet</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>LifeDemo</servlet-name>
  	<servlet-class>app02.LifeDemo</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>LifeDemo</servlet-name>
  	<url-pattern>/LifeDemo</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>InitDemo</servlet-name>
  	<servlet-class>app03.InitDemo</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>InitDemo</servlet-name>
  	<url-pattern>/InitDemo</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>ConfigDemo</servlet-name>
  	<servlet-class>app04.ConfigDemo</servlet-class>
  	<!-- 配置Servlet初始化参数 -->
  	<init-param>
  		<param-name>student</param-name>
  		<param-value>haoyue</param-value>
  	</init-param>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ConfigDemo</servlet-name>
  	<url-pattern>/ConfigDemo</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>ContextDemo1</servlet-name>
  	<servlet-class>app05.ContextDemo1</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ContextDemo1</servlet-name>
  	<url-pattern>/ContextDemo1</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>ContextDemo2</servlet-name>
  	<servlet-class>app05.ContextDemo2</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ContextDemo2</servlet-name>
  	<url-pattern>/ContextDemo2</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>ContextDemo3</servlet-name>
  	<servlet-class>app05.ContextDemo3</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ContextDemo3</servlet-name>
  	<url-pattern>/ContextDemo3</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>ContextDemo4</servlet-name>
  	<servlet-class>app05.ContextDemo4</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ContextDemo4</servlet-name>
  	<url-pattern>/ContextDemo4</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>RequestDemo</servlet-name>
  	<servlet-class>app06.RequestDemo</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>RequestDemo</servlet-name>
  	<url-pattern>/RequestDemo</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>ForwardDemo</servlet-name>
  	<servlet-class>app07.ForwardDemo</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>ForwardDemo</servlet-name>
  	<url-pattern>/ForwardDemo</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>GetDataServlet</servlet-name>
  	<servlet-class>app07.GetDataServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>GetDataServlet</servlet-name>
  	<url-pattern>/GetDataServlet</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>RedirectDemo</servlet-name>
  	<servlet-class>app07.RedirectDemo</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>RedirectDemo</servlet-name>
  	<url-pattern>/RedirectDemo</url-pattern>
  </servlet-mapping>
</web-app>
```

