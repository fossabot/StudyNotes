package app02;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月25日 上午9:36:48
* @version 1.0.0
*/
public class StudentTest {

	public static void main(String[] args) {
		//创建学生对象
		Student student = new Student();
		//为属性赋值
		student.name = "郝月";
		student.age = 18;
		student.weight = 45;
		//调用方法
		student.show();
	}
}
