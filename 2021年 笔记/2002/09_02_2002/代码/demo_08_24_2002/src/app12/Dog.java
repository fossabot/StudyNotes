package app12;
/** 
* @description 狗狗类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月2日 上午9:09:41
* @version 1.0.0
*/
public class Dog {

	//狗狗的名字
	private String name;
	//狗狗的品种
	private String strain;
	
	//无参构造方法
	public Dog(){}

	//有参构造方法
	public Dog(String name, String strain) {
		this.name = name;
		this.strain = strain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
}
