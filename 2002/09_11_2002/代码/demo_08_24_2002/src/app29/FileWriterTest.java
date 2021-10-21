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
