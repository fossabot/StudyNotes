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
