package app06;
/** 
* @description 类和对象
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月25日 上午9:25:36
* @version 1.0.0
*/
public class Student {

	//学生姓名
	private String name;
	//学生年龄
    private int age;
	//学生体重
    private double weight;
	
	//无参构造方法
	public Student(){}
	
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
		//流程控制语句
		/*if(){
			
		}else{
			
		}*/
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	//方法
	public void show(){
		System.out.println("我们要好好学习...");
	}
}
