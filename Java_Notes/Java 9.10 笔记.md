# 9月10日笔记 2002 5678节

## 1.回顾 [[Java 9.8 笔记]]

1. 文件的概念
2. 文件一般放置在哪里
3. 如何实例化一个文件
4. 文件路径参数的两种方式
5. File类中的常用方法，创建文件（2个）、查看文件的详细信息
6. 本节课我们要继续讲解文件的删除

## 2.文件的输入输出

**File类**

```java
package app24;

import java.io.File;

/** 
* @description 文件的常用方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月8日 上午8:35:33
* @version 1.0.0
*/
public class FileMethod {

	public static void main(String[] args) throws Exception {
		//实例化文件对象
		File file = new File("D:\\javaio\\test.txt");
		//实例化对象
		FileMethod fileMethod = new FileMethod();
		//调用方法
		//fileMethod.createFile(file);
		//fileMethod.showFileInfo(file);
		fileMethod.deleteFile(file);
	}
	
	//创建文件
	public void createFile(File file) throws Exception{
		//判断文件是否存在
		if(!file.exists()){
			//创建文件（空文件）
			file.createNewFile();
			System.out.println("文件创建成功...");
		}
	}
	
	//删除文件
	public void deleteFile(File file) throws Exception{
		//判断文件是否存在
		if(file.exists()){
			//删除文件
			file.delete();
			System.out.println("文件删除成功...");
		}
	}
	
	//显示文件的基本信息
	public void showFileInfo(File file) throws Exception{
		//判断文件是否存在
		if(file.exists()){
			//判断是否是文件
			if(file.isFile()){
				System.out.println("文件的相对路径是："
						+ file.getPath());
				System.out.println("文件的绝对路径是："
						+ file.getAbsolutePath());
				System.out.println("文件的名称为："
						+ file.getName());
				System.out.println("文件的长度为："
						+ file.length());
			}
			//判断是否是文件夹
			if(file.isDirectory()){
				System.out.println("该文件是文件夹...");
			}
		}else{
			System.out.println("文件不存在...");
		}
	}
}
```

**FileInputStream（文件输入字节流）**

```java
package app25;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/** 
* @description 文件字节输入流
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月10日 下午1:36:50
* @version 1.0.0
*/
public class FileInputStreamDemo {

	public static void main(String[] args) throws Exception {
		//实例化文件字节输入流对象
		FileInputStream fis = new 
				FileInputStream("1.txt");
		//读取的字节编码 byte
		int bys = 0;
		//循环读取，一次读取一个字节 ASCII(A:65,a:97)
		while((bys=fis.read())!=-1){
			System.out.print((char)bys);
		}
		//关闭资源
		fis.close();
	}
}
```

**FileOutputStream（文件输出字节流）**

```java
package app26;

import java.io.FileOutputStream;

/** 
* @description 文件字节输出口
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月10日 下午2:11:24
* @version 1.0.0
*/
public class FileOutputStreamDemo {

	public static void main(String[] args) throws Exception {
		//实例化文件输出流对象
		//输出流如果文件不存在，则会自动创建文件
		FileOutputStream fos = new 
				FileOutputStream("2.txt");
		//将写入内容转换为字节数组
		byte[] bytes = "i miss you".getBytes();
		//写入数据，一次写入一个字节数组
		fos.write(bytes);
		//关闭资源
		fos.close();
	}
}
```

> 如何复制音频或影音文件？

将D盘中javaio目录下1.mp3文件复制到E盘下javaio目录中