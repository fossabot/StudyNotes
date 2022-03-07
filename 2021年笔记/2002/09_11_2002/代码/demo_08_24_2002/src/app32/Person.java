package app32;

import java.io.Serializable;

/** 
* @description 序列与反序列化,标记接口
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月11日 上午11:07:25
* @version 1.0.0
*/
public class Person implements Serializable {

	private static final long serialVersionUID = 4880758675908227199L;
	//姓名
	private String name;
	//年龄
	private int age;
	
	//无参构造方法
	public Person(){}
	
	//有参构造方法
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
