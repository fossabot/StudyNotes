package app11;

import java.util.ArrayList;
import java.util.List;

/** 
* @description 初识ArrayList
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月1日 上午9:25:39
* @version 1.0.0
*/
public class NewsTest {

	public static void main(String[] args) {
		//实例化集合对象
		List<News> newsList = new ArrayList<>();
		//向集合中添加元素,匿名对象作参数
		newsList.add(new 
				News(1, "冶金校区延期开学", "小编"));
		newsList.add(new 
				News(2, "我国航天事业飞速发展", "小编"));
		newsList.add(new 
				News(3, "今年为我党建党100周年", "小编"));
		//List集合的遍历方式，3种
		//方式1：普通for遍历
		/*for(int i=0;i<newsList.size();i++){
			//链式调用
			System.out.println(newsList.get(i).getTitle());
		}*/
		//方式2：增强for遍历
		for (News news : newsList) {
			System.out.println(news);
		}
	}
}
