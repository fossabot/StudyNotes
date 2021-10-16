## 9月27日笔记 2002 56节

## 1.回顾 [[Java 9.25 笔记]]

1. 请求转发与重定向
   1. 请求转发的地址栏不会发生改变，而重定向地址栏发生改变
   2. 请求转发为一次请求，而重定向为两次请求
   3. 如果需要传递数据，那么使用请求转发
   4. 请求转发是服务器行为，而重定向为客户端行为
   5. 请求转发无法访问该Web应用以外的资源，而重定向可以访问该应用以外的资源

## 2.Servlet

**重定向访问外部的web资源**、

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
		//response.sendRedirect(request.getContextPath() + "/GetDataServlet");
		//重定向到外部资源（其他Web应用）
		response.sendRedirect("/test_2002/index.html");
	}
}
```

**Cookie技术**

Cookie技术的弊端，cookie对象只能存储字符串，无法存储对象，并且cookie存储的内容不能超过4KB,所以如果想要存储对象，那么需要使用Session技术去处理

**Cookie技术的常用方法**

添加数据

语法：

```java
public void addCookie(Cookie cookie)
```

**获取数据**

语法：

```java
public Cookie[] getCookies()
```

设置cookie的有效期(单位为秒)

语法：

```java
public void setMaxAge(int expiry)
```

**设置Cookie有效时间的辨析**

1. 如果设置有效时间为正整数（单位：秒），cookie数据会保存在浏览器的硬盘中
2. 如果设置有效时间为负正数，cookie数据保存浏览器中内存中
3. 如果设置有效时间为零：表示删除同名cookie

```java
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
```

```java
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
  
  <servlet>
  	<servlet-name>CookieDemo</servlet-name>
  	<servlet-class>app08.CookieDemo</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>CookieDemo</servlet-name>
  	<url-pattern>/CookieDemo</url-pattern>
  </servlet-mapping>
  
  <servlet>
  	<servlet-name>DeleteCookie</servlet-name>
  	<servlet-class>app08.DeleteCookie</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>DeleteCookie</servlet-name>
  	<url-pattern>/DeleteCookie</url-pattern>
  </servlet-mapping>
</web-app>
```

