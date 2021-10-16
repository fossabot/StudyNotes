package app07;
/** 
* @description 企鹅类（子类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:05:43
* @version 1.0.0
*/
public class Penguin extends Pet {

	//宠物的性别
	private String sex = "Q妹";
	
	//无参构造方法
	public Penguin(){}
	
	//有参构造方法
	public Penguin(String name,String sex){
		//调用父类的构造方法
		super(name);
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	//方法重写 public 默认 protected private
	@Override
	public void print() {
		//调用父类的成员方法
		super.print();
		System.out.println("企鹅的性别为：" + this.sex);
	}

	@Override
	public void toHospital() {
		System.out.println("吃药、疗养...");
	}
}
