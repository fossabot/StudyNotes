package app05;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月27日 下午1:30:48
* @version 1.0.0
*/
public class StudentTest {

	public static void main(String[] args) {
		//创建学生数组
		Student[] stus = new Student[3];
		//创建三个学生
		Student stu1 = new Student("英健", 18, 48);
		Student stu2 = new Student("子怡", 19, 49);
		Student stu3 = new Student("思莹", 20, 50);
		//将元素放入学生数组
		stus[0] = stu1;
		stus[1] = stu2;
		stus[2] = stu3;
		//增强for遍历
		for (Student student : stus) {
			//打印输出三位美女的年龄
			System.out.println(student.name + "\t" + student.age);
		}
	}
}
