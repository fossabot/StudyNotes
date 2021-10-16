# 9月6日笔记 2002 56节

## 1.回顾 [[Java 9.4 笔记]]

1. Map接口，7个方法
2. Map集合的遍历方式
   1. 增强for遍历
   2. 迭代器遍历
   3. Entry接口（了解）
3. String类equals()，equals()与==
4. 字符串的连接
   1. “+”
   2. concat()

## 2.String类

**字符串提取方法**

![结果](../assets/提取方法.png)

```java
package app19;
/** 
* @description 字符串的提取方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月6日 下午1:34:34
* @version 1.0.0
*/
public class StringMethod {

	public static void main(String[] args) {
		//String str = "abcdabcd";
		String str = "  abcd abcd  ";
		//获取第一次出现的位置
		//int indexOf = str.indexOf('b'); //1
		//int indexOf = str.indexOf("b"); //1
		//System.out.println(indexOf);
		//获取最后一次出现的位置
		//int lastIndexOf = str.lastIndexOf('b'); //5
		//int lastIndexOf = str.lastIndexOf("b");
		//System.out.println(lastIndexOf);
		//提取从索引位置开始的字符串部分
		//String substring = str.substring(3); //dabcd
		//提取begIndex开始到endIndex结束的字符串部分
		//满足前包后不包的原则
		//String substring = str.substring(3, 5); //dab
		//System.out.println(substring); //da
		System.out.println(str.length()); //13
		//去掉首尾空格
		String trim = str.trim();
		System.out.println(trim.length()); //9
	}
}
```

**面试题**

```java
String word = "Hello,      ";
word = word.trim();
String s = word.concat("小鱼儿!");
int index1 = s.indexOf(',');
int index2 = s.indexOf('!');
System.out.println(s.substring(______, _______));

答案：index1+1 index2
```

**字符串的拆分**

String类提供了split()方法，将一个字符串分隔为子字符串，结果作为==字符串数组==返回

```java
package app20;
/** 
* @description 字符串的分隔
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月6日 下午2:35:14
* @version 1.0.0
*/
public class StringSplit {

	public static void main(String[] args) {
		//定义字符串（歌词）
		String words = "长亭外 古道边 芳草碧连天 晚风拂 柳笛声残 夕阳山外山";
		//分隔字符串，字符串数组
		String[] split = words.split(" ");
		System.out.println("分隔后的歌词为：");
		//增强for遍历
		for (String string : split) {
			System.out.println(string);
		}
	}
}
```

