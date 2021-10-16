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
