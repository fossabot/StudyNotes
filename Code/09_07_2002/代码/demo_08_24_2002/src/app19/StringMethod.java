package app19;
/** 
* @description 字符串的提取方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月6日 下午1:34:34
* @version 1.0.0
*/
public class StringMethod {

	public static void main(String[] args) {
		//String str = "abcdabcd";
		String str = "  abcd abcd  ";
		//获取第一次出现的位置
		//int indexOf = str.indexOf('b'); //1
		//int indexOf = str.indexOf("b"); //1
		//System.out.println(indexOf);
		//获取最后一次出现的位置
		//int lastIndexOf = str.lastIndexOf('b'); //5
		//int lastIndexOf = str.lastIndexOf("b");
		//System.out.println(lastIndexOf);
		//提取从索引位置开始的字符串部分
		//String substring = str.substring(3); //dabcd
		//提取begIndex开始到endIndex结束的字符串部分
		//满足前包后不包的原则
		//String substring = str.substring(3, 5); //dab
		//System.out.println(substring); //da
		System.out.println(str.length()); //13
		//去掉首尾空格
		String trim = str.trim();
		System.out.println(trim.length()); //9
	}
}
