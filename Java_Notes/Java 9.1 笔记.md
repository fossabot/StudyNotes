# 9月1日笔记 2002 12节
## 1. 回顾 [[Java 8.31 笔记]]

1. 接口的概念

2. 一个类继承（extends）一个类，一个类实现（implements）一个接口

3. 抽象类与接口的区别

 1. 抽象类使用abstract关键字修饰，接口使用interface关键字修饰

 2. 接口中只能有抽象方法，抽象类中可以抽象方法，也可以有普通方法

 3. 抽象类与接口均不能被实例化

## 2. 接口

**实现多个接口**

- 一个类只能继承一个父类（==单继承==），却可以实现多个接口，也可以同时抽象类和实现接口

语法：

```java
public class 类名 implements 接口1,接口2,...{
	//类的成员
}
```

<font color="red">注：extends关键字必须位于implements关键字之前</font>

## 3. 集合框架
> 为什么使用集合框架？

**如果并不知道程序运行时会需要多少对象，或者**需要更复杂的方式存储对象，那么我们需要使用Java的 ==集合框架==

  

集合框架概述：Java集合框架，提供一套性能优良，使用方便的 ==接口== 和 ==类== ，位于 ==java.util== 包中

**Java集合框架包含的内容**

 ![[集合.png]] 

**Collection接口：**存储一组不唯一、无序的对象

**List接口：**存储一组不唯一、有序（插入顺序）的对象

**Set接口：**存储一组不唯一、无序的对象

**Map接口：**存储一组键值对象，提供
<font color="red">
key
</font>
到
<font color="red">
value
</font>的映射

## 4.List接口实现类

==ArrayList== 实现了 ==长度可变== 的数组，在内存中分配连续的空间。遍历元素和随机访问元素的效率比较高,

*即查询的效率较高*

==LinkedList== 采用链表存储方式。==插入，删除== 元素时效率比较高

**ArrayList类**

泛型：将对象的类型作为参数，指定到其他类或者方法上，从而保证类型转换的 ==安全性和稳定性== ，其本质是参数化类型。

```java
package app10;
  
import java.util.ArrayList;
import java.util.List;
  
/** 
* @description 泛型
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月1日 上午9:28:26
* @version 1.0.0
*/
public class ListDemo {
  
	public static void main(String[] args) {
	//实例化集合对象，父类引用指向子类对象
	List list = new ArrayList();
	//向集合中加入元素
		list.add("俊奇");
		list.add(35);
		list.add(true);
	}
}
```