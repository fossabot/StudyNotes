# Java 9.15 笔记
## 1. 回顾 [[Java 9.11 笔记]]
 - tomcat 启动和停止
	 1. 启动 `startup.bat`
	 2. 停止 `shutdown.bat`
 - tomcat 简介
 - 如何在 Eclipse 上挂载 Tomcat
 - 解决了 Tomcat 闪退问题

 ## 2. Tomcat
  - <font color="red">如何修改 Tomcat 服务器的端口号？</font>
  - <u>http://localhost:==8080==</u>

### 2.1 部署 Web 项目
1. 导出 War 文件
2. 将 War 文件放入 Tomcat 服务器内的 Webapp 下
3. 使用浏览器进行测试

## 3.Servlet
 - 什么是 MVC ?
 - M (<font color="red">Model</font>): 用于封装数据，处理业务逻辑。`JAVAVBEAN`
 - V (<font color="red">View</font>): 显示数据
 - C (<font color="red">Controller</font>): 接受请求,调用`JAVABEAN`去处理请求`Servlet`

### 3.1 Servlet 是做什么的
 - 本身不做任何任务处理，只是接收请求并决定调用哪个`JAVABEAN`去处理请求，确定用哪个页面来显示处理返回的数据。
 - <font color="gray">概念: </font>是一种 ==服务器端== 的`Java`应用程序，只有当一个服务器端的程序使用了Servlet API的时候，这个服务端的程序才能称之为Servlet。

#### 3.1.1 创建 Servlet 的方式
1. 实现`javax.servelt.Servlet`接口
2. 继承`javax.servlet.GenericServlet`类
3. 继承`javax.servlet.http.Servlet`类