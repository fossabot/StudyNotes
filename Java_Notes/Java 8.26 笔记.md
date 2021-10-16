# 8月26日笔记 2002 12节
## 1.回顾 [[Java 8.25 笔记]]

1. 方法（四种）=》可变参数（超纲）

2. 类和对象=》属性和方法是如何操作的

## 2.全局变量和局部变量

	2.1 全局变量（成员变量）：在类内部定义的变量
	2.2 局部变量：在方法中定义的变量

| **比较** | **成员变量**                                                                                                                                              | **局部变量**     |
| -------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------- |
| 定义位置 | 直接在类中定义                                                                                                                                            | 定义在方法中     |
| 声明赋值 | 可以在声明时赋初始值；若不赋值，会有默认初始值，基本数据类型的值为0，引用类型的值为null                                                                   | 在使用前需要赋值 |
| 作用域   | 在整个类内部都是可见的，所有成员方法都可以使用它，如果访问权限允许，还可以在类外部使用                                                                    | 在使用前需要赋值 |

 - <font color="red">注意</font>

	1. 在同一个方法中，不允许有同名的局部变量。在不同的方法中，可以有同名的局部变量。
	2. 局部变量可以和成员变量同名，并且在使用时，局部变量具有更高的优先级。


```java
package app03;
/** 
* @description 类和对象
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月25日 上午9:25:36
* @version 1.0.0
*/
public class Student {
  
 //学生姓名
 String name;
 //学生年龄
 int age;
 //学生体重
 double weight;
 //无参构造方法
 public Student(){}
 //方法
 public void show(){
 System.out.println("我们要好好学习...");
 }
}
```

  

```java
package app03;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月26日 上午8:28:02
* @version 1.0.0
*/
public class Test {
  
 public void calc1(int num){
 num += 1;
 }
 public void calc2(Student student){
 student.age += 1;
 }
 public static void main(String[] args) {
 //实例化对象
 Test test = new Test();
 int n = 8;
 //调用方法
 test.calc1(n);
 //实例化学生对象
 Student jiangxin = new Student();
 jiangxin.age = 18;
 //调用方法
 test.calc2(jiangxin);
 System.out.println(n + "-----" + jiangxin.age);
 }
}
```

  

**执行结果**

![[传参.png]]

<font color="red">
	注：基本数据类型传递的是变量的值，改变一个变量不会影响另一个变量的值，而引用数据类型传参，传递的是这个对象的引用（内存地址）
</font>

 -  定义包含三个元素的对象数组，数据类型为Student，并使用for循环遍历输出每个学生的年龄。
 	- 这里应该如何实现？

```java
package app04;
/** 
* @description 类和对象
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月25日 上午9:25:36
* @version 1.0.0
*/
public class Student {
  
 //学生姓名
 String name;
 //学生年龄
 int age;
 //学生体重
 double weight;
 //无参构造方法
 public Student(){}
 //方法
 public void show(){
 System.out.println("我们要好好学习...");

 }
}

```

```java

package app04;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月26日 上午9:13:06
* @version 1.0.0
*/

public class StudentTest {
 	public static void main(String[] args) {
 		//实例化学生数组 int[] scores = new int[3];
 		Student[] stus = new Student[3];
 		//实例化3个学生
 		Student stu1 = new Student();
 		//为属性赋值
 			stu1.name = "思蒙";
 			stu1.age = 18;
 			stu1.weight = 45;
			Student stu2 = new Student();
 			stu2.name = "玉迪";
 			stu2.age = 19;
 			stu2.weight = 40;
 			Student stu3 = new Student();
 			stu3.name = "月儿";
 			stu3.age = 20;
 			stu3.weight = 50;
 			//将学生对象放入数组中
 			stus[0] = stu1;
 			stus[1] = stu2;
 			stus[2] = stu3;
 		//遍历数组=>方式1：普通for遍历 方式2：增强for遍历
		//方式1
 			/*for(int i=0;i<stus.length;i++){
			 System.out.println(stus[i].age);
 			}*/
 		//方式2
 			for (Student student : stus) {
 			System.out.println(student.age);
		 }
 	}
}

```