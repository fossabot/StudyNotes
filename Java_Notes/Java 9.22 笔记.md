# 9月22日笔记 2002 12节

## 1.回顾 [[Java 9.17 笔记]]

1. Servlet的Init()方法
   1. 有参init()方法：Servlet的生命周期方法
   2. 无参Init()方法：sun公司为我们开发人员量身听做的为程序初始化的一个方法
2. ServletConfig对象
   1. 一个Servlet有且仅有一个该对象
   2. 能够获取Servlet的初始化参数

## 2.Servlet

**ServletConfig对象获取初始化参数**

```java
package app04;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig对象
 * @author Administrator
 *
 */
public class ConfigDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//读取Servlet初始化参数
		//获取ServletConfig对象
		ServletConfig servletConfig = this.getServletConfig();
		//获取初始化参数
		//String initParameter = servletConfig.getInitParameter("student");
		//System.out.println("初始化参数为：" + initParameter);
		//获取Servlet名称
		String servletName = this.getServletConfig().getServletName();
		System.out.println("servlet的名称为：" + servletName);
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
</web-app>
```

**ServletContext对象**

ServletContext为Web应用中最大的域对象，该对象在Web应用中有且仅有一个

**服务器端的三个 以对象**

1. HttpServletRequest：一次请求
2. HttpSession：一次会话
3. ServletContext：一个Web应用中有且仅有一个

**ServletContext对象获取Web应用路径**

> 什么是Web应用路径？

部署到tomcat服务器上运行的web应用名称

```java
package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext对象获取Web应用路径
 * @author Administrator
 *
 */
public class ContextDemo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		//方式1:通过ServletConfig对象获取
		//ServletContext servletContext = this.getServletConfig().getServletContext();
		//方式二：使用当前对象获取ServletContext对象（推荐使用）
		ServletContext servletContext = this.getServletContext();
		//获取Web应用路径
		String contextPath = servletContext.getContextPath();
		System.out.println("web应用路径为：" + contextPath);
		//重定向
		response.sendRedirect(request.getContextPath() + "/01_index.jsp");
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
</web-app>
```

