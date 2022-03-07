package app15;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** 
* @description Map接口的常用方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月4日 上午8:22:22
* @version 1.0.0
*/
public class MapDemo {

	public static void main(String[] args) {
		//实例化Map集合对象，父类引用指向子类对象
		Map<String, String> map = new HashMap<>();
		//向集合加入元素
		map.put("CN", "中华人民共和国");
		map.put("RU", "俄罗斯联邦");
		map.put("FR", "法兰西共和国");
		map.put("US", "美利坚合众国");
		//通过键获取值
		String china = map.get("CN");
		System.out.println(china);
		//删除指定键映射的键值对
		map.remove("US");
		//判断是否有指定键映射的键值对
		if(map.containsKey("US")){
			System.out.println("集合中存在美国...");
		}else{
			System.out.println("美国被移除了...");
		}
		//返回键的集合
		Set<String> keySet = map.keySet();
		System.out.println(keySet);
		//返回值的集合
		Collection<String> values = map.values();
		System.out.println(values);
		System.out.println("集合中有" + map.size()
				+ "个元素");
	}
}
