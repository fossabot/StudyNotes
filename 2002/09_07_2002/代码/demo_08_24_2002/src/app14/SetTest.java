package app14;

import java.util.HashSet;

import java.util.Iterator;

/** 
* @description Set集合的遍历方式
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月3日 下午2:12:57
* @version 1.0.0
*/
public class SetTest {

	public static void main(String[] args) {
		//实例化Set集合
		HashSet<News> newsSet = new HashSet<>();
		//向集合中加入数据
		newsSet.add(new 
				News(1, "国足惨败澳大利亚", "小编"));
		newsSet.add(new 
				News(2, "地铁4号线预计两年内完工", "小编"));
		newsSet.add(new 
				News(3, "我国宇航员实现太空行走", "小编"));
		//遍历Set集合
		//方式1：增强for遍历
		/*for (News news : newsSet) {
			System.out.println(news);
		}*/
		//方式2：迭代器遍历
		//获取迭代器对象
		Iterator<News> it = newsSet.iterator();
		//循环判断集合中是否有下一个元素
		while(it.hasNext()){
			//获取当前元素
			News news = it.next();
			System.out.println(news);
		}
	}
}
