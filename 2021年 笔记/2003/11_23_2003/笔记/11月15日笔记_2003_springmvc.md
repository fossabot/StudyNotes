# Spring MVC

## 1.Spring MVC的简介

Spring MVC属于SpringFrameWork的==后续产品==，已经融合在Spring Web Flow里面。Spring 框架提供了构建 [Web](https://baike.baidu.com/item/Web/150564) 应用程序的全功能 ==MVC== 模块。使用 Spring 可插入的 MVC 架构，从而在使用Spring进行WEB开发时，可以选择使用Spring的Spring MVC框架或集成其他MVC开发框架，如Struts1(现在一般不用)，Struts 2(一般==老项目==使用)等等。

## 2.MVC模式

MVC是Model、View、Controller的缩写，分别代表Web应用程序中3中职责

1. 模型(Model)：用户存储数据级处理用户请求的业务逻辑
2. 视图(View)：向控制台提交数据，显示模型中的数据
3. 控制器(Controller)：根据视图提出的请求判断将请求和数据交给哪个模型处理，将处理后的关系结果交给哪个视图更新显示

> 关于Servlet的MVC模式？(jd_2003)

1. 模型：一个或多个JavaBean
2. 视图：一个或多个JSP页面
3. 控制器：一个或多个==Servlet==对象

![结果](../assets/Servlet MVC.png)



## 3.Spring MVC的工作原理

![结果](../assets/SpringMVC执行原理.png)

SpringMVC的工作流程

1. 客户端请求提交到DispatherServlet（核心控制器）
2. 由DispatherServlet控制器寻找一个或多个HandlerMapping，找到处理请求的Controller
3. DispatherServlet将请求提交到Controller
4. Controller调用业务逻辑处理后返回ModelAndView（==对象+视图组成==）
5. DispatherServlet寻找一个或多个ViewResolver（视图解析器），找到ModelAndView指定的视图
6. 视图负责将结果显示到客户端

## 4.Spring MVC环境搭建

环境搭建步骤

1. 创建Maven Web项目（==选择maven web的骨架结构==）
2. 在pom.xml中编写Spring MVC的所有jar包的坐标（==下载到我们的本地仓库==）
3. 在web.xml中配置核心控制器（==DispatcherServlet==）
4. 配置处理POST请求乱码的过滤器(==Spring中自带该过滤器==)

配置web.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!-- 配置Spring MVC核心控制器 -->
    <servlet>
        <servlet-name>DispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>DispatcherServlet</servlet-name>
        <url-pattern>*.action</url-pattern>
    </servlet-mapping>

    <!-- 配置Spring提供的针对于POST请求的中文乱码问题 -->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
</web-app>
```

<font color="red">注：如果在web.xml文件中没有指定springmvc的配置文件，那么springmvc会自动在WEB-INF目录下寻找名为DispatcherServlet-*.xml</font>

## 5.Spring MVC快速入门（xml版）

**编写DispatcherServlet-servlet.xml**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!--
        注册action
            class：表示处理类的全路径名
            name：表示请求路径
            必须配置
     -->
    <bean name="/hello.action" class="app01.HelloAction"/>

    <!--
        映射器
        BeanNameUrlHandlerMapping表示bean的name属性当作url请求
        可选
     -->
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>

    <!--
        适配器
        SimpleControllerHandlerAdapter表示查找实现了Controller接口的Action类
        可选
    -->
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>

    <!--
        视图解析器
        InternalResourceViewResolver表示通过ModelAndView对象中的视图名到真正的页面
        可选
     -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"/>
</beans>
```

```java
package app01;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction implements Controller {

    public HelloAction(){
        System.out.println("HelloAction-->" + this.hashCode());
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("HelloAction:handleRequest()");
        //ModelAndView表示视图封装数据和真实路径
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("message","这是我们第一个Spring MVC应用程序，映射器_适配器_视图解析器都可以省略...");
        //封装视图（完整的视图路径）
        modelAndView.setViewName("/jsp/success.jsp");
        return modelAndView;
    }
}
```

<font color="red">注：Spring MVC为单例的，scope="singleton"</font>

## 6.自定义的spring.xml配置文件

指定加载spring.xml文件

```xml
<init-param>
	<param-name>contextConfigLocation</param-name>
    <param-value>classpath:spring.xml</param-value>
</init-param>
```

**配置视图解析器（spring.xml）**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- 注册Action（必） -->
    <bean name="/hello.action" class="app02.HelloAction"/>

    <!--
        如果Action中书写的是视图逻辑名称，那么视图解析器必须配置
        如果Action中书写的是视图的完整名称，那么视图解析器就是可选配置
     -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- /jsp/success.jsp -->
        <!-- 路径前缀 -->
        <property name="prefix" value="/jsp/"/>
        <!-- 路径后缀 -->
        <property name="suffix" value=".jsp"/>
        <!-- 前缀 + 视图逻辑名 + 后缀 = 真实路径（/jsp/success.jsp） -->
    </bean>
</beans>
```

```java
package app02;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloAction implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //实例化ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("message","这是我们第二个Spring MVC应用程序...");
        //原来是如何实现的呢？
        //modelAndView.setViewName("/jsp/success.jsp");
        //现在封装视图的逻辑名称
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
```

## 7.第一个Spring MVC应用注解版

> 使用基于注解的控制器有什么优点？

1. 在基于注解的控制器中，可以编写多个处理方法，进而可以处理多个请求，这就允许将相关的操作编写在一个控制类中，从而减少控制器类的数量，方便以后的维护
2. 基于注解的控制器不需要在配置文件中部署映射，仅需要使用@RequestMapping注解去注解一个方法进行请求处理

**@Controller注解**

概述：在Spring MVC中，使用@Controller注解类型声明某类的实例是一个控制器

**@RequestMapping注解**

概述：在基于注解的控制类中，可以为每个请求编写对应的处理方法。使用@RequestMapping注解将请求和处理方法一一对应，@RequestMapping注解类型有两种。

1. 方法级别

   方法级别的@RequestMapping注解作用在处理方法上。该注解的value属性将请求URL映射到方法，value属性是改注解的默认属性，如果只有一个value属性，则可以省略该属性。

2. 类级别

   在类级别注解的情况下，控制类中所有方法都将映射为类级别请求

<font color=red>注：为了方便维护程序，建议开发者使用类级别注解，将相关处理放在同一个控制类中</font>

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 让Spring IOC容器扫描带有@Controller的类 -->
    <context:component-scan base-package="app03"/>

    <!-- 配置视图解析器 -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```

```java
package app03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAction {

    /**
     * 业务方法
     * 只要是/hello.action的请求，都会由HelloAction对象中的hello()方法处理
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/hello.action")
    public String hello(Model model) throws Exception{
        System.out.println("HelloAction():hello()");
        //保存数据
        model.addAttribute("message","加油，大数据2003...");
        //返回逻辑视图名
        return "success";
    }

    /**
     * 业务方法
     * 只要是/hello.action的请求，都会由都会由HelloAction对象中的bye()方法处理
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bye.action")
    public String bye(Model model) throws Exception{
        System.out.println("HelloAction():bye()");
        //保存数据
        model.addAttribute("message","战胜困难，大数据2003...");
        return "success";
    }
}
```

## 8.在action中写多个业务控制方法

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 开启注解扫描 -->
    <context:component-scan base-package="app04"/>
</beans>
```

```java
package app04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

    //URL：/user/register
    /**
     * 用户注册
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register")
    public String register(Model model) throws Exception{
        //保存数据
        model.addAttribute("message","员工注册成功...");
        return "/jsp/success.jsp";
    }
}
```

**My97时间控件**

1. 下载时间控件

2. 引入时间控件

   ```jsp
   <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
   ```

3. 设置单击事件

4. 使用控件进行日期选择

![结果](../assets/M97.png)

```java
package app04;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

    //URL：/user/register
    /**
     * 用户注册
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/register")
    public String register(Model model) throws Exception{
        //保存数据
        model.addAttribute("message","员工注册成功...");
        return "/jsp/success.jsp";
    }

    /**
     * 员工登录
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(Model model) throws Exception{
        //保存数据
        model.addAttribute("message","员工登录成功...");
        return "/jsp/success.jsp";
    }
}
```

## 9.在业务控制方法中接收参数

> 如何在业务控制方法中接收参数？

1. 通过处理方法的形参接收请求参数（@RequestParam注解）
2. 通过实体bean接收请求参数
3. 通过HttpServletRequest接收请求参数
4. @PathVariable注解接收URL中的请求参数

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 开启注解扫描 -->
    <context:component-scan base-package="app05"/>
</beans>
```

```java
package app05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    /**
     * 用户注册，只能接收POST请求
     * @param model
     * @param username
     * @param salary
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(Model model,String username,double salary) throws Exception{
        System.out.println("用户注册-->" + username + "：" + salary);
        //保存数据
        model.addAttribute("message","员工注册成功...");
        return "/jsp/success.jsp";
    }

    //如果执行method = RequestMethod.POST，那么GET/POST均可
    /**
     * 员工登录，既能接收POST请求也能接收GET请求
     * @param model
     * @param username
     * @return
     * @throws Exception
     */
    //@RequestMapping(value = "/login")
    //等价于下面的写法
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    public String login(Model model,String username) throws Exception{
        System.out.println("用户名-->" + username);
        //保存数据
        model.addAttribute("message","员工登录成功...");
        return "/jsp/success.jsp";
    }
}
```

<font color="red">注：业务控制方法的参数名称必须与页面表单中的控件名一致</font>

## 10.在业务控制方法中写入传统的Web参数

> Spring MVC在业务方法中可以传递哪些Web应用参数？

1. HttpServletRequest：请求=>请求转发
2. HttpServletReponse：响应=>重定向
3. HttpSession：会话=>可以将数据直接保存到会话中

```java
package app06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    /**
     * 用户注册，只能接收POST请求
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取用户名和薪水
        String username = request.getParameter("username");
        String salary = request.getParameter("salary");
        System.out.println("用户注册-->" + username + ":" + salary);
        //将用户名和薪水保存到session对象中
        request.getSession().setAttribute("username",username);
        request.getSession().setAttribute("salary",salary);
        //推荐使用（SpringMVC）=>转发到一个视图
        //return "/jsp/success.jsp";
        //Servlet API中的请求转发
        //request.getRequestDispatcher("/jsp/success.jsp").forward(request,response);
        //对于Servlet API中的请求转发，在Spring MVC中如何实现
        //return "forward:/jsp/success.jsp";
        //Servlet API中的重定向
        //response.sendRedirect(request.getContextPath() + "/jsp/success.jsp");
        //对于Servlet API中的重定向，在Spring MVC中如何实现
        return "redirect:/jsp/success.jsp";
    }
}
```

## 11.@RequestParam注解获取参数

**@RequestParam注解**

概述：通过处理方法的形参接收请求参数

> @RequestParam注解有哪些属性？

1. value属性：参数名

2. required属性：是否必须，有两个值分别为true和false，如果不加该属性，默认为required=true

   <font color=red>注：可以简化为，@RequestParam String username</font>

3. defaultValue属性：该参数的默认值

   <font color="red">注：如果没有传递该参数，则该参数为此属性设置的默认值</font>

![结果](../assets/400.png)

```java
package app07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(@RequestParam String username, @RequestParam double salary, HttpSession session) throws Exception{
        System.out.println("用户注册-->" + username + ":" + salary);
        //将数据保存到session对象中
        session.setAttribute("username",username);
        session.setAttribute("salary",salary);
        //重定向
        return "redirect:/jsp/success.jsp";
    }
}
```

```java
@RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(@RequestParam String username, @RequestParam Double salary, HttpSession session) throws Exception{
        System.out.println("用户注册-->" + username + "：" + salary);
        //将数据保存到session对象中
        session.setAttribute("username",username);
        session.setAttribute("salary",salary);
        //重定向
        return "redirect:/jsp/success.jsp";
    }
```

<font color=red>注：需要将参数由基本数据类型改为包装类，如：double->Double，如果没有传值，则会赋值为null，这样就避免了400错误的产生</font>

**完成写法**

```java
@RequestMapping(method = RequestMethod.POST,value = "/register")
public String register(@RequestParam String username, @RequestParam(value = "salary",required = true,defaultValue = "7500") Double salary, HttpSession session) throws Exception{
    System.out.println("用户注册-->" + username + "：" + salary);
    //将数据保存到session对象中
    session.setAttribute("username",username);
    session.setAttribute("salary",salary);
    //重定向
    return "redirect:/jsp/success.jsp";
}
```

<font color="red">注：如果没有传值，则值为null，如果有默认值，那么值为默认值</font>

## 12.@InitBinder注解

> 在Spring MVC能不能用实体类去接收一个参数呢？

我们可以使用@ModelAttribute注解

**@ModelAttribute注解**

概述：该注解放在处理方法的形参上时，用于将多个请求参数封装到一个实体对象，从而简化数据绑定的流程，而且自动暴露为模型数据用于视图页面展示时使用

```java
package app08;

import java.util.Date;

/**
 * 用户类
 */
public class User {

    //用户编号
    private Integer id = 1;
    //用户名
    private String username;
    //薪水
    private Double salary;
    //入职日期
    private Date hiredate;

    //无参构造
    public User(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                ", hiredate=" + hiredate +
                '}';
    }
}
```

```java
package app08;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(@ModelAttribute User user, Model model) throws Exception{
        System.out.println("用户注册：" + user.toString());
        //将user对象绑定到Model对象中
        model.addAttribute("user",user);
        //跳转到成功页面
        return "/jsp/success.jsp";
    }
}
```

![](../assets/日期格式问题.png)



<font color=red>注：如果表单中有日期格式，那么在Spring MVC中需要进行字符串转日期类型的转换，@ModelAttribute可以省略</font>

```java
package app08;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserAction {

    /**
     * 自定义类型转换器
     * 解决字符串转日期类型，如果不配置，则会出现400错误
     * @param
     * @param
     * @return
     * @throws Exception
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) throws Exception{
        binder.registerCustomEditor(
                Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true)
        );
    }

    @RequestMapping(method = RequestMethod.POST,value = "/register")
    public String register(@ModelAttribute User user, Model model) throws Exception{
        System.out.println("用户注册：" + user.toString());
        //将user对象绑定到Model对象中
        model.addAttribute("user",user);
        //跳转到成功页面
        return "/jsp/success.jsp";
    }
}
```

## 13.@ResponseBody注解响应JSON文本返回

> 由于没有讲解jQuery，我们不知道DOM的基本使用，以及JSON和AJAX

[JSON](https://baike.baidu.com/item/JSON)([JavaScript](https://baike.baidu.com/item/JavaScript) Object Notation, JS 对象简谱) 是一种==轻量级==的数据交换格式。

**JSON的格式**

JSON对象：

```javascript
{ "firstName": "Brett", "lastName":"McLaughlin", "email": "aaaa" }
```

JSON数组：

```javascript
[
    { "firstName": "Brett", "lastName":"McLaughlin", "email": "aaaa" },
    { "firstName": "Brett", "lastName":"McLaughlin", "email": "aaaa" },
    { "firstName": "Brett", "lastName":"McLaughlin", "email": "aaaa" }
]
```

在注解开发时，需要两个重要的JSON格式转换注解，分别是@RequestBody和==@ReponseBody==

1. @RequestBody：用于将请求体中的数据绑定到方法的形参中，该注解应用在方法的形参上
2. ==@ReponseBody==：用于直接返回return对象，该注解应用在方法上

<font color=red>注：@ReponseBody的本质为将某对象转换成json文本，如果@ReponseBody遗漏就会出现404错误</font>

```java
//处理自定义对象
@RequestMapping(value = "/beantojson")
@ResponseBody
public Emp beantojson() throws Exception{
    //创建Emp对象
    Emp emp = new Emp();
    //封装数据
    emp.setId(1);
    emp.setUsername("兴龙");
    emp.setSalary(7000D);
    emp.setHiredate(new Date());
    return emp;
}
```

```javascript
{"id":1,"username":"兴龙","salary":7000.0,"hiredate":1637549309926}
```

```java
//处理List集合对象
@RequestMapping("/listbeantojson")
@ResponseBody
public List<Emp> list2json() throws Exception{
    //实例化集合对象
    List<Emp> empList = new ArrayList<>();
    //向集合中添加元素
    empList.add(new Emp(1,"昱霖",7000D,new Date()));
    empList.add(new Emp(2,"南洋",8000D,new Date()));
    empList.add(new Emp(3,"耘铭",9000D,new Date()));
    return empList;
}
```

```javascript
[{"id":1,"username":"昱霖","salary":7000.0,"hiredate":1637550144437},{"id":2,"username":"南洋","salary":8000.0,"hiredate":1637550144437},{"id":3,"username":"耘铭","salary":9000.0,"hiredate":1637550144437}]
```

**Map集合**

```java
//处理Map集合
@RequestMapping(value = "/maptojson")
@ResponseBody
public Map<String,Object> map2json() throws Exception{
    //实例化List集合对象
    List<Emp> empList = new ArrayList<>();
    //向集合中添加元素
    empList.add(new Emp(1,"晓亮",7000D,new Date()));
    empList.add(new Emp(2,"刘鉴",8000D,new Date()));
    empList.add(new Emp(3,"郑莹",9000D,new Date()));
    //创建Map集合对象
    Map<String,Object> map = new LinkedHashMap<>();
    //向map集合中添加元素 EasyUI分页
    map.put("total",empList.size());
    map.put("rows",empList);
    return map;
}
```

```java
{"total":3,"rows":[{"id":1,"username":"晓亮","salary":7000.0,"hiredate":1637644859348},{"id":2,"username":"刘鉴","salary":8000.0,"hiredate":1637644859348},{"id":3,"username":"郑莹","salary":9000.0,"hiredate":1637644859348}]}
```

JSON中有两种结构

1. 对象结构：对象结构以”{“开始，以”}“结束，中间由0个或多个英文逗号分隔的key/value对构成，key和value之间以英文”:“分隔
2. 数组结构：数据结构以"["开头，以”]“结束，中间由0个或多个英文逗号分隔的值的列表组成

<font color="red">注：对象和数组结构也可以分别构成更为复杂的数据结构，如Map集合（JSON）</font>

***由于没有讲解jQuery，这里面涉及jQuery Ajax所以我们还会回到这个demo***

## 14.Restful风格实现

> 如何在我们URL中接收请求参数？

==@PathVariable注解==接收URL中的请求参数

> 什么是Restful风格？

Restful就是一个==资源定位==、==资源操作==的风格。不是标准也不是协议，只是一种风格。基于这个风格设计的软件可以更简洁、更有层次、更易于实现缓存等机制

**传统方式传参**

```
http://127.0.0.1:8080/jd_2003/GoodsDetailServlet.action?id=1
```

**Restful风格传参**

```
http://127.0.0.1:8080/jd_2003/GoodsDetailServlet/1.action
```

```java
package app10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserAction {

    //跳转到修改页面（数据回显）
    @RequestMapping("/select")
    public String userByIdSelect(Model model) throws Exception{
        //实例化用户类
        User user = new User();
        //保存数据
        model.addAttribute("user",user);
        return "userEdit";
    }

    //修改方法
    @RequestMapping("/userEdit/{id}")
    public String userEdit(Model model,@PathVariable Integer id) throws Exception{
        System.out.println("修改的id为->" + id);
        //保存数据
        model.addAttribute("message","修改成功...");
        return "success";
    }
}
```

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		传统方式资源：http://127.0.0.1/ssm/item/userEdit.action?id=1
		restful方式：http://127.0.0.1/ssm/item/userEdit/1.action
	 -->
	 <a href="${pageContext.request.contextPath}/user/userEdit/${user.id}.action">修改</a>
</body>
</html>
```

## 15.文件上传下载

