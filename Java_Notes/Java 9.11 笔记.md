# 9月11日笔记 2002 1234节

## 1.回顾 [[Java 9.10 笔记]]

1. File文件的方法讲完了，删除文件
2. 文件输入字节流：FileInputStream
3. 文件输出字节流：FileOutputStream
4. 对于mp3的复制（使用Java IO流操作）

## 2.文件输入输出

考察：输入和输出流的混合应用

```java
package app27;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/** 
* @description 音频文件的复制
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月10日 下午2:49:28
* @version 1.0.0
*/
public class FisAndFosTest {

	public static void main(String[] args) throws Exception {
		//实例化文件输入流对象
		FileInputStream fis = new 
				FileInputStream("D:\\javaio\\1.mp3");
		//实例化文件输出流对象
		FileOutputStream fos = new 
				FileOutputStream("E:\\javaio\\晚秋.mp3");
		//定义缓冲区
		byte[] bys = new byte[1024];
		//读取的数组长度
		int len = 0;
		//循环读取，一次读取一个字节数组
		while((len=fis.read(bys))!=-1){
			//写入数据
			fos.write(bys, 0, len);
			//刷新缓冲区
			fos.flush();
		}
		//关闭资源
		fis.close();
		fos.close();
	}
}
```

**FileReader（文件字符输入流）**

```java
package app28;

import java.io.FileReader;

/** 
* @description 文件字符输入流
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月11日 上午9:04:52
* @version 1.0.0
*/
public class FileReadTest {

	public static void main(String[] args) throws Exception {
		//实例化文件输入流对象
		FileReader fr = new FileReader("3.txt");
		//读取的字符
		int ch = 0;
		//循环读取，每次读取一个字符
		while((ch=fr.read())!=-1){
			System.out.print((char)ch);
		}
		//关闭资源
		fr.close();
	}
}
```

**FileWriter(文件字符输出流)**

```java
package app29;

import java.io.FileWriter;

/**  
* @description 文件字符输出流
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月11日 上午9:19:07
* @version 1.0.0
*/
public class FileWriterTest {

	public static void main(String[] args) throws Exception {
		//实例化文件输出流对象
		FileWriter fw = new FileWriter("4.txt");
		//写入内容
		fw.write("冶金大数据二班");
		//关闭资源
		fw.close();
	}
}
```

> 使用字符流对象完成音频或影音文件的复制呢？

仍然需要字符输入流和字符输出流的混合应用

```JAVA
package app30;

import java.io.FileReader;
import java.io.FileWriter;

/** 
* @description 使用字符流复制音频文件
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月11日 上午9:34:27
* @version 1.0.0
*/
public class FrAndFwTest {

	public static void main(String[] args) throws Exception {
		//实例化文件字符输入流
		FileReader fr = new 
				FileReader("D:\\javaio\\1.mp3");
		//实例化文件字符输出流
		FileWriter fw = new 
				FileWriter("E:\\javaio\\晚秋.mp3");
		//定义缓冲区
		char[] chs = new char[1024];
		//读取的数组长度
		int len = 0;
		//循环读取，一次读取一个字符数组
		while((len=fr.read(chs))!=-1){
			//写入数据
			fw.write(chs, 0, len);
			//刷新缓冲区
			fw.flush();
		}
		//关闭资源 -128-127(字节流) 0-65535(字符流)
		fr.close();
		fw.close();
	}
}
```

<font color="red">注：复制图片、影音、视频的二进制文件建议使用字节流</font>

**缓冲字符输入流（BufferedReader）和缓冲字符输出流（BufferWriter）**

```java
package app31;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/** 
* @description 缓冲字符输入流与缓冲字符输出流
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月11日 上午10:21:56
* @version 1.0.0
*/
public class BrAndBwTest {

	public static void main(String[] args) throws Exception {
		//实例化缓冲字符输入流对象
		BufferedReader br = new 
				BufferedReader(new FileReader("5.txt"));
		//实例化缓冲字符输出流对象
		BufferedWriter bw = new 
				BufferedWriter(new FileWriter("6.txt"));
		//定义字符缓冲区
		char[] chs = new char[1024];
		//读取数组的长度
		int len = 0;
		//循环读取，一次读取一个字符数组
		while((len=br.read(chs))!=-1){
			//写入数据
			bw.write(chs, 0, len);
			//刷新缓冲区
			bw.flush();
		}
		//关闭资源
		br.close();
		bw.close();
	}
}
```

**序列化与反序列化**

序列化：将对象的状态写入到特定流的过程

反序列化：从特定的流中获取数据重新构建对象的过程

序列化的步骤

1. 实现Serializable接口
2. 创建对象输出流
3. 调用WriteObject()方法将对象写入文件
4. 关闭资源

**ObjectInputStream(对象字节输入流)与ObjectOutputStream(对象字节输出流)**

```java
package app32;

import java.io.Serializable;

/** 
* @description 序列与反序列化,标记接口
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月11日 上午11:07:25
* @version 1.0.0
*/
public class Person implements Serializable {

	private static final long serialVersionUID = 4880758675908227199L;
	//姓名
	private String name;
	//年龄
	private int age;
	
	//无参构造方法
	public Person(){}
	
	//有参构造方法
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
```

