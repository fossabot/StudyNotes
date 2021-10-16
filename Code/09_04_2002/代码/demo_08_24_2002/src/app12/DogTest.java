package app12;

import java.util.ArrayList;
import java.util.List;

/** 
* @description ArrayList的常用方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月2日 上午9:18:42
* @version 1.0.0
*/
public class DogTest {

	public static void main(String[] args) {
		//实例化集合对象,父类引用指向子类对象
		List<Dog> dogList = new ArrayList<>();
		//实例化3条狗狗
		Dog dog1 = new Dog("王子", "金毛");
		Dog dog2 = new Dog("白雪", "史宾格");
		Dog dog3 = new Dog("旺仔", "泰迪");
		//向集合中放入元素
		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
		//示例化一只狗狗
		Dog dog4 = new Dog("肥牛", "法斗");
		//在指定位置添加元素
		dogList.add(1, dog4);
		//删除元素
		dogList.remove(dog4);
		//按照下标删除元素
		dogList.remove(0);
		//判断是否存在某元素
		if(dogList.contains(dog3)){
			System.out.println("泰迪在集合中...");
		}else{
			System.out.println("味大，被卖了...");
		}
		System.out.println("集合中一共有" + dogList.size()
				+ "条狗狗");
		//遍历集合
		for(int i=0;i<dogList.size();i++){
			//链式调用
			System.out.println(dogList.get(i).getName());
		}
	}
}
