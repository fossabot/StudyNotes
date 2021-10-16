package app18;
/** 
* @description 字符串连接
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月4日 上午11:10:28
* @version 1.0.0
*/
public class StringConcat {

	public static void main(String[] args) {
		//定义字符串
		String firstName = "科比";
		//String lastName = "布莱恩特";
		//拼接字符串
		//firstName.concat(lastName);
		//concat()方法是操作的字符串的副本
		String allName = firstName.concat("布莱恩特");
		System.out.println(allName);
		
		//定义字符串
		//String school = "辽宁冶金职业技术学院";
		//String major = "大数据2班";
		//System.out.println(school + major);
	}
}
