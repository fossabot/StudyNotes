package app07;
/** 
* @description 狗狗类（子类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:00:08
* @version 1.0.0
*/
public class Dog extends Pet {

	//狗狗的品种
	private String strain = "牧羊犬";
	
	//无参构造方法
	public Dog(){}
	
	//有参构造方法
	public Dog(String name,String strain){
		//调用父类的构造方法
		super(name);
		this.strain = strain;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
	//方法重写 注解
	@Override
	public void print() {
		//调用父类的成员方法
		super.print();
		System.out.println("狗狗的品种为：" + this.strain);
	}

	@Override
	public void toHospital() {
		System.out.println("打针、吃药...");
	}
}
