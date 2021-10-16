package app07;
/** 
* @description 宠物类（父类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午8:27:21
* @version 1.0.0
*/
public abstract class Pet {

	//宠物名称
	private String name = "无名氏";
	//宠物健康值
	private int health = 100;
	//宠物亲密度
	private int love = 20;
	
	//无参构造方法
	public Pet(){}
	
	//有参构造方法
	public Pet(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}
	
	//打印方法（宠物的自白）
	public void print(){
		System.out.println("宠物的自白：\n"
				+ "宠物的名字：" + this.name
				+ "\t宠物的健康值" + this.health
				+ "\t宠物的亲密度" + this.love);
	}
	
	//给宠物看病
	public abstract void toHospital();
}
