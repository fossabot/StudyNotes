package app05;
/** 
* @description 类和对象
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月25日 上午9:25:36
* @version 1.0.0
*/
public class Student {

	//学生姓名
	String name;
	//学生年龄
	int age;
	//学生体重
	double weight;
	
	//无参构造方法
	public Student(){}
	
	//有参构造方法
	public Student(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	//方法
	public void show(){
		System.out.println("我们要好好学习...");
	}
}
