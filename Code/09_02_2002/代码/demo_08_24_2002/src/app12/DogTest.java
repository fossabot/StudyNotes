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
		System.out.println("集合中一共有" + dogList.size()
				+ "条狗狗");
		//遍历集合
		for(int i=0;i<dogList.size();i++){
			//链式调用
			System.out.println(dogList.get(i).getName());
		}
	}
}
