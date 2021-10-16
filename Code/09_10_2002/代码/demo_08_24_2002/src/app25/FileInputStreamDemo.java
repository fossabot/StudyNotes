package app25;

import java.io.FileInputStream;

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
