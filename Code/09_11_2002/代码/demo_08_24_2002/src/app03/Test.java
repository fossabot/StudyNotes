package app03;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月26日 上午8:28:02
* @version 1.0.0
*/
public class Test {

	public void calc1(int num){
		num += 1;
	}
	
	public void calc2(Student student){
		student.age += 1;
	}
	
	public static void main(String[] args) {
		//实例化对象
		Test test = new Test();
		int n = 8;
		//调用方法
		test.calc1(n);
		//实例化学生对象
		Student jiangxin = new Student();
		jiangxin.age = 18;
		//调用方法
		test.calc2(jiangxin);
		System.out.println(n + "-----" + jiangxin.age);
	}
}
