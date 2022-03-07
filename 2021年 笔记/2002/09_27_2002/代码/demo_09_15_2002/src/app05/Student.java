package app05;

/**
 * 学生类
 * @author Administrator
 *
 */
public class Student {

	//姓名
	private String name;
	//年龄
	private int age;
	
	//无参构造方法
	public Student(){}

	//有参构造方法
	public Student(String name, int age) {
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
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
