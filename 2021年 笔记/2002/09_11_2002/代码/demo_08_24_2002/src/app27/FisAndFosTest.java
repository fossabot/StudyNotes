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
