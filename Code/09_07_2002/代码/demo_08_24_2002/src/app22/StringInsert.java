package app22;

import java.util.Scanner;

/** 
* @description 字符串插入
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月7日 上午8:43:02
* @version 1.0.0
*/
public class StringInsert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一串数字：");
		String nums = input.next();
		//实例化StringBuffer对象
		StringBuffer sb = new StringBuffer(nums);
		//循环插入
		for(int i=nums.length()-3;i>0;i-=3){
			//插入字符串
			sb.insert(i, ",");
		}
		System.out.println(sb.toString());
		//关闭资源
		input.close();
	}
}
