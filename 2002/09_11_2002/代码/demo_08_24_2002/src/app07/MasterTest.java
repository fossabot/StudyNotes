package app07;
/** 
* @description 主人类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午11:12:08
* @version 1.0.0
*/
public class MasterTest {

	//给给宠物看病，父类作为方法形参
	public void cure(Pet pet){
		//判断健康值
		if(pet.getHealth()<60){
			//调用看病方法
			pet.toHospital();
		}
	}
	
	public static void main(String[] args) {
		//示例化主人类
		MasterTest mt = new MasterTest();
		//实例化一个宠物（企鹅）
		Pet penguin = new Penguin();
		//使企鹅生病
		penguin.setHealth(10);
		//调用治疗方法
		mt.cure(penguin);
		
		//实例化一个宠物，父类引用指向子类对象
		//Pet dog = new Dog();
		//使狗狗生病
		//dog.setHealth(20);
		//调用治疗方法
		//mt.cure(dog);
	}
}
