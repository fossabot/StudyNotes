## 9月8日笔记 2002 12节

## 1.回顾 [[Java 9.7 笔记]]

1. StringBuffer类，toString()、append()、insert()
2. 操作日期和时间
   1. java.util.Date
   2. 日期时间格式化类：SimpleDateFormat

## 2.输入和输出

> 文件一般存储在哪里？

存储在硬盘、光盘、软盘中

> Java程序如何访问文件属性的呢？

Java API：java.==io==.File类

**创建文件对象**

```java
File file = new File("文件路径");
```

文件路径有两种方式：

1. C:/text.txt
2. C:\\\text.txt(==推荐使用==)

**File类常用的方法**

| **方法名称**                   | **说明**                                                     |
| ------------------------------ | ------------------------------------------------------------ |
| **boolean  exists( )**         | **判断文件或目录是否存在**                                   |
| **boolean  isFile( )**         | **判断是否是文件**                                           |
| **boolean  isDirectory( )**    | **判断是否是目录**                                           |
| **String  getPath( )**         | **返回此对象表示的文件的相对路径名**                         |
| **String  getAbsolutePath( )** | **返回此对象表示的文件的绝对路径名**                         |
| **String  getName( )**         | **返回此对象表示的文件或目录的名称**                         |
| **boolean  delete( )**         | **删除此对象指定的文件或目录**                               |
| **boolean  createNewFile( )**  | **创建名称的空文件，不创建文件夹**                           |
| **long length()**              | **返回文件的长度，单位为字节**, **如果文件不存在，则返回** **0L** |

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
		fileMethod.showFileInfo(file);
	}
	
	//创建文件
	public void createFile(File file) throws Exception{
		//判断文件是否存在
		if(!file.exists()){
			//创建文件
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

