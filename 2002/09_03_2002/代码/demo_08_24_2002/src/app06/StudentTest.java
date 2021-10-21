package app06;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月27日 下午2:21:39
* @version 1.0.0
*/
public class StudentTest {

	public static void main(String[] args) {
		//创建学生数组
		Student[] stus = new Student[3];
		//创建3个学生对象
		Student stu1 = new Student();
		//为属性赋值
		stu1.setName("德臣");
		stu1.setAge(18);
		stu1.setWeight(52);
		Student stu2 = new Student();
		//为属性赋值
		stu2.setName("美楠");
		stu2.setAge(19);
		stu2.setWeight(50);
		Student stu3 = new Student();
		//为属性赋值
		stu3.setName("白杨");
		stu3.setAge(20);
		stu3.setWeight(51);
		//将学生放入数组中
		stus[0] = stu1;
		stus[1] = stu2;
		stus[2] = stu3;
		//循环遍历学生信息（增强for遍历）
		for (Student student : stus) {
			System.out.println(student.getName()
					+ "\t" + student.getAge());
		}
	}
}
