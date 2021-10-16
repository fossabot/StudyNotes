# 9月23日笔记 2002 12节

## 1.回顾 [[Java 9.22 笔记]]

1. ServletConfig完成了获取初始化参数
2. ServletConfig对象获取Servlet名称
3. ServletContext对象是服务器端最大域对象，一个Web应用有且仅有一个ServletContext对象
4. ServletContext对象获取Web应用路径

## 2.Servlet

```java
package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取Web应用参数
 * @author Administrator
 *
 */
public class ContextDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//获取web应用参数
		String initParameter = servletContext.getInitParameter("student");
		System.out.println("参数：" + initParameter);
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
</web-app>
```

**ServletContext对象保存和获取数据**

从请求中保存属性

语法：

```java
public void setAttribute("属性名","属性值");
```

从请求中获取属性

语法：

```java
public Object getAttribute("属性名");
```

```java
package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 获取Web应用参数
 * @author Administrator
 *
 */
public class ContextDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//获取web应用参数
		String initParameter = servletContext.getInitParameter("student");
		System.out.println("参数：" + initParameter);
	}
}
```

```java
package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 向请求中保存数据
 * @author Administrator
 *
 */
public class ContextDemo3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取域对象（ServletContext）
		ServletContext servletContext = this.getServletContext();
		//将数据保存在域对象中
		//servletContext.setAttribute("name", "yiming");
		servletContext.setAttribute("student", new Student("yanze", 20));
		System.out.println("保存成功...");
	}
}
```

```java
package app05;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 从请求中获取数据
 * @author Administrator
 *
 */
public class ContextDemo4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		//从请求中获取数据
		//String name = (String) servletContext.getAttribute("name");
		//System.out.println("name=>" + name);
		//强制类型转换
		Student student = (Student) servletContext.getAttribute("student");
		System.out.println(student);
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
</web-app>
```

