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
