# 9月16日笔记  2002 1234节

## 1.回顾 [[Java 9.15 笔记]]

1. tomcat部署动态网站
   1. 新建web项目
   2. 导出war文件
   3. 将war文件放入webapps目录下
   4. 启动tomcat服务器
   5. 在浏览器中进行测试
2. Servlet的基本概念
3. MVC三层架构的编程模式

## 2.Servlet

**第一个Servlet程序**

配置Servlet

```xml
<servlet>
	<servlet-name>Servlet名称（全局唯一）</servlet-name>
    <servlet-class>Servlet所在路径（类的全路径限定名）</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>Servlet名称（全局唯一）</servlet-name>
    <url-pattern>访问Servlet的URL</url-pattern>
</servlet-mapping>
```

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
</web-app>
```

**Servlet的生命周期**

servlet的生命周期大致分为四个阶段

1. 加载和实例化
2. 初始化
3. 处理请求
4. 销毁

| 生命周期 | 谁来做       | 何时做                                                       |
| -------- | ------------ | ------------------------------------------------------------ |
| 实例化   | Servlet 容器 | 当Servlet容器启动或者容器检测到客户端请求时                  |
| 初始化   | Servlet 容器 | 实例化后，容器调用Servlet的init()初始化对象                  |
| 处理请求 | Servlet 容器 | 得到客户端请求并做出处理时                                   |
| 销毁     | Servlet 容器 | 当程序中的Servlet对象不再使用的时候，     或者Web服务器停止运行的时候 |

```java
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
</web-app>
```

