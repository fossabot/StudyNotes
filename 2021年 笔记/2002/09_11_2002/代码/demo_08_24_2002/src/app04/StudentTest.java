package app04;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月26日 上午9:13:06
* @version 1.0.0
*/
public class StudentTest {

	public static void main(String[] args) {
		//实例化学生数组 int[] scores = new int[3];
		Student[] stus = new Student[3];
		//实例化3个学生
		Student stu1 = new Student();
		//为属性赋值
		stu1.name = "思蒙";
		stu1.age = 18;
		stu1.weight = 45;
		Student stu2 = new Student();
		stu2.name = "玉迪";
		stu2.age = 19;
		stu2.weight = 40;
		Student stu3 = new Student();
		stu3.name = "月儿";
		stu3.age = 20;
		stu3.weight = 50;
		//将学生对象放入数组中
		stus[0] = stu1;
		stus[1] = stu2;
		stus[2] = stu3;
		//遍历数组=>方式1：普通for遍历 方式2：增强for遍历
		//方式1
		/*for(int i=0;i<stus.length;i++){
			System.out.println(stus[i].age);
		}*/
		//方式2
		for (Student student : stus) {
			System.out.println(student.age);
		}
	}
}
