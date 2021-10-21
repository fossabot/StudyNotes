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
