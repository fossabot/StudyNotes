package app16;

import java.util.HashMap;
//import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/** 
* @description Map集合的遍历方式
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月4日 上午9:12:20
* @version 1.0.0
*/
public class MapTest {

	public static void main(String[] args) {
		//实例化集合对象
		Map<String, News> newsMap = new HashMap<>();
		//向集合中添加元素
		newsMap.put("国际", new 
				News(1, "新闻1", "小编"));
		newsMap.put("体育", new 
				News(2, "新闻2", "小编"));
		newsMap.put("娱乐", new 
				News(3, "新闻3", "小编"));
		//Map集合的遍历方式（3种）
		//方式1：增强for遍历
		//获取键的集合
		//Set<String> keySet = newsMap.keySet();
		//增强for遍历
		/*for (String key : keySet) {
			//通过键取值
			News news = newsMap.get(key);
			System.out.println(news);
		}*/
		//方式2：迭代器遍历
		//获取键的集合
		//Set<String> keySet = newsMap.keySet();
		//获取迭代器对象
		//Iterator<String> it = keySet.iterator();
		//循环遍历键的集合
		/*while(it.hasNext()){
			//获取集合中的每一个键
			String key = it.next();
			//通过key取value
			News news = newsMap.get(key);
			System.out.println(news);
		}*/
		//方式3：使用Entry接口的方式（了解）
		//获取Entry接口集合
		Set<Entry<String,News>> entrySet = 
									newsMap.entrySet();
		//增强for遍历
		for (Entry<String, News> entry : entrySet) {
			System.out.println(entry.getKey()
					+ "\t" + entry.getValue());
		}
	}
}
