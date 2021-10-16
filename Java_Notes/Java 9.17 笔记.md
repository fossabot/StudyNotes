# Java 9.17 笔记
## 1. 回顾 [[Java 9.16 笔记]]
1. `Servlet`编写，使用`Servlet API` | 继承了 `HttpServlet` 。
2. 配置 `Servlet` ，需要在 Web 应用的 `Web.xml` 中进行配置。
3. **Servlet 的生命周期，四个阶段**
	1. 实例化 `Servlet`
	2. 初始化 `Servlet`
	3. 处理请求 `Service() 方法`
	4. <font color="red">销毁</font>（停止服务器）
## 2. Servlet
 - **Servlet 中的 `init` 方法。**
	> 无参 `init()` : 该方法是 Servlet 编写初始化代码的方法，是 Sun 公司设计出来专门给开发人员量身定做的方法，用来实现程序的初始化。
	> 有参`init()` : Servlet的生命周期方法，一般不需要覆盖有参`init()`方法。
- **为什么报<font color="red"> 405 </font>错误码？**
	1. 如果直接在浏览器访问，则调用 `Servlet` 中的 `doGet()` 方法或 `Service()` 方法。
	2. 如果 form 表单提交时，`method="get"`，则调用 Servlet 中 `doGet()`方法或 `service()` 方法。
	3.  如果 form 表单提交时，`method="post"`，则调用 `Servet` 中 `doPost()` 或 `service()` 方法。
-  **ServletConfig 对象**
	-  `ServletConfig` 对象为 `Servlet` 中 `init()` 方法的参数，每一个 `Servlet` 有且仅有一个 `ServletConfig` 对象。
	-  <font color="red">注意：Tomcat 服务器这些参数