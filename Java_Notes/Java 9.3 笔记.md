# 9月3日笔记 2002 5678节

## 1.回顾 [[Java 9.2 笔记]]

1. List集合的实现类，ArrayList和LinkedList
2. 泛型：提高数据的安全性与稳定性
3. List集合的遍历方式
   1. 普通for遍历
   2. 增强for遍历
   3. 迭代器遍历
4. ArrayList集合的常用方法

## 2.List集合

ArrayList集合的常用方法

```java
package app12;

import java.util.ArrayList;
import java.util.List;

/** 
* @description ArrayList的常用方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月2日 上午9:18:42
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
		//示例化一只狗狗
		Dog dog4 = new Dog("肥牛", "法斗");
		//在指定位置添加元素
		dogList.add(1, dog4);
		//删除元素
		dogList.remove(dog4);
		//按照下标删除元素
		dogList.remove(0);
		//判断是否存在某元素
		if(dogList.contains(dog3)){
			System.out.println("泰迪在集合中...");
		}else{
			System.out.println("味大，被卖了...");
		}
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

**LinkedList的常用方法**

| **方法名**                      | **说明**                           |
| ------------------------------- | ---------------------------------- |
| **void** **addFirst**(Object o) | **在列表的首部添加元素**           |
| **void** **addLast**(Object o)  | **在列表的末尾添加元素**           |
| **Object** **getFirst**()       | **返回列表中的第一个元素**         |
| **Object** **getLast**()        | **返回列表中的最后一个元素**       |
| **Object** **removeFirst**()    | **删除并返回列表中的第一个元素**   |
| **Object** **removeLast**()     | **删除并返回列表中的最后一个元素** |

## 3.Set集合

Set接口存储一组==唯一==，==无序==的对象，HashSet是Set接口最常用的实现类

```java
package app13;

import java.util.HashSet;
import java.util.Set;

/** 
* @description 初识Set集合
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月3日 下午1:45:56
* @version 1.0.0
*/
public class SetDemo {

	public static void main(String[] args) {
		//实例化Set集合
		Set<String> set = new HashSet<>();
		//创建三个元素
		String s1 = new String("java");
		String s2 = s1;
		String s3 = new String("JAVA");
		//向集合中加入元素
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println("集合中有：" + set.size()
				+ "个元素");
	}
}
```

Set对象采用equals()方法比较两个字符串是否相等

```java
Set set=new HashSet();
String s1=new String("java");
String s2=s1;
String s3=new String ("java");
set.add(s1);
set.add(s2);
set.add(s3);
System.out.println(set.size());
```

**Set集合的遍历方式（两种）**

1. 增强for遍历
2. 迭代器遍历，iterate对象中包含两个方法
   1. hasNext()：判断是否存在下一个元素
   2. next()：返回要访问的下一个元素

```java
package app14;

import java.util.HashSet;
import java.util.Iterator;

/** 
* @description Set集合的遍历方式
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月3日 下午2:12:57
* @version 1.0.0
*/
public class SetTest {

	public static void main(String[] args) {
		//实例化Set集合
		HashSet<News> newsSet = new HashSet<>();
		//向集合中加入数据
		newsSet.add(new 
				News(1, "国足惨败澳大利亚", "小编"));
		newsSet.add(new 
				News(2, "地铁4号线预计两年内完工", "小编"));
		newsSet.add(new 
				News(3, "我国宇航员实现太空行走", "小编"));
		//遍历Set集合
		//方式1：增强for遍历
		/*for (News news : newsSet) {
			System.out.println(news);
		}*/
		//方式2：迭代器遍历
		//获取迭代器对象
		Iterator<News> it = newsSet.iterator();
		//循环判断集合中是否有下一个元素
		while(it.hasNext()){
			//获取当前元素
			News news = it.next();
			System.out.println(news);
		}
	}
}
```

