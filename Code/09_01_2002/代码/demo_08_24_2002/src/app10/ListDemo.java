package app10;

import java.util.ArrayList;
import java.util.List;

/** 
* @description 泛型
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月1日 上午9:28:26
* @version 1.0.0
*/
public class ListDemo {

	public static void main(String[] args) {
		//实例化集合对象，父类引用指向子类对象
		List list = new ArrayList();
		//向集合中加入元素
		list.add("俊奇");
		list.add(35);
		list.add(true);
	}
}
