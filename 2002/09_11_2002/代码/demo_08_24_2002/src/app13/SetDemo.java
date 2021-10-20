package app13;

import java.util.HashSet;
import java.util.Set;

/** 
* @description 初识Set集合
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月3日 下午1:45:56
* @version 1.0.0
*/
public class SetDemo {

	public static void main(String[] args) {
		//实例化Set集合
		Set<String> set = new HashSet<>();
		//创建三个元素
		String s1 = new String("java");
		String s2 = s1;
		String s3 = new String("JAVA");
		//向集合中加入元素
		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println("集合中有：" + set.size()
				+ "个元素");
	}
}
