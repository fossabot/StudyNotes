# 9月2日笔记 2002 1234节
## 1.回顾 [[Java 9.1 笔记]]

1. 为什么使用集合框架

2. 集合框架的概述

3. 一个类只能有一个直接父类，但可以实现多个接口

4. 泛型作用：提高数据的安全性与稳定性

## 2.List集合的实现类

**List集合的遍历方式**

1. 普通for遍历

2. 增强遍历

3. 迭代器遍历（ ==Set集合进行讲解== ）

```java
package app11;
/** 
* @description 新闻类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月1日 上午9:10:50
* @version 1.0.0
*/
public class News extends Object {
  
 //新闻编号
 private int id;
 //新闻标题
 private String title;
 //新闻作者 
 private String creator;
 //无参构造方法
 public News(){}
  
 //有参构造方法
 public News(int id, String title, String creator) {
 this.id = id;
 this.title = title;
 this.creator = creator;
 }
  
 public int getId() {
 return id;
 }
  
 public void setId(int id) {
 this.id = id;
 }
  
 public String getTitle() {
 return title;
 }
  
 public void setTitle(String title) {
 this.title = title;
 }
  
 public String getCreator() {
 return creator;
 }
  
 public void setCreator(String creator) {
 this.creator = creator;
 }
  
 @Override
 public String toString() {
 return "News [id=" + id + ", title=" + title + ", creator=" + creator + "]";
 }
}
```

```java
package app11;
  
import java.util.ArrayList;
import java.util.List;
  
/** 
* @description 初识ArrayList
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月1日 上午9:25:39
* @version 1.0.0
*/
public class NewsTest {

 public static void main(String[] args) {
 //实例化集合对象
 List<News> newsList = new ArrayList<>();
 //向集合中添加元素,匿名对象作参数
 newsList.add(new 
 News(1, "冶金校区延期开学", "小编"));
 newsList.add(new 
 News(2, "我国航天事业飞速发展", "小编"));
 newsList.add(new 
 News(3, "今年为我党建党100周年", "小编"));
 //List集合的遍历方式，3种
 //方式1：普通for遍历
 /*for(int i=0;i<newsList.size();i++){
 //链式调用
 System.out.println(newsList.get(i).getTitle());
 }*/
 //方式2：增强for遍历
 for (News news : newsList) {
 System.out.println(news);
 }
 }
}
```

**ArrayList的常用方法**

| **方法名**                         | **说明**                                                                             |
| ---------------------------------- | ------------------------------------------------------------------------------------ |
| **boolean** **add(Object o)**      | **在列表的末尾顺序添加元素，起始索引位置从**0**开始**                                |
| void  add(int index,Object **o)**  | **在指定的索引位置添加元素。索引位置必须介于**0和列表中元素个数之间                  |
| **int** **size()**                 | **返回列表中的元素个数**                                                             |
| **Object  get(**int **index)**     | **返回指定索引位置处的元素。取出的元素是**Object**类型，使用前需要进行强制类型转换** |
| **boolean** **contains(Object o)** | **判断列表中是否存在指定元素**                                                       |
| **boolean** **remove(Object o)**   | **从列表中删除元素**                                                                 |
| **Object  remove(**int **index)**  | **从列表中删除指定位置元素，起始索引位置从**0**开始**                                |

```java
package app12;
/** 
* @description 狗狗类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月2日 上午9:09:41
* @version 1.0.0
*/

public class Dog {
 //狗狗的名字
 private String name;
 //狗狗的品种
 private String strain;
 //无参构造方法
 public Dog(){}
  
 //有参构造方法
 public Dog(String name, String strain) {
 this.name = name;
 this.strain = strain;
 }
  
 public String getName() {
 return name;
 }
  
 public void setName(String name) {
 this.name = name;
 }
  
 public String getStrain() {
 return strain;
 }
  
 public void setStrain(String strain) {
 this.strain = strain;
 }
}
```

```java
package app12;
  
import java.util.ArrayList;
import java.util.List;
  
/** 
* @description ArrayList的常用方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月2日 上午9:18:42
* @version 1.0.0
*/

public class DogTest {
 public static void main(String[] args) {
 //实例化集合对象,父类引用指向子类对象
 List<Dog> dogList = new ArrayList<>();
 //实例化3条狗狗
 Dog dog1 = new Dog("王子", "金毛");
 Dog dog2 = new Dog("白雪", "史宾格");
 Dog dog3 = new Dog("旺仔", "泰迪");
 //向集合中放入元素
 dogList.add(dog1);
 dogList.add(dog2);
 dogList.add(dog3);
 System.out.println("集合中一共有" + dogList.size()
 + "条狗狗");
 //遍历集合
 for(int i=0;i<dogList.size();i++){
 //链式调用
 System.out.println(dogList.get(i).getName());
 }
 }
}
```