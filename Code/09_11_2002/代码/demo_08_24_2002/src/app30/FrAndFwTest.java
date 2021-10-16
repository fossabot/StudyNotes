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
