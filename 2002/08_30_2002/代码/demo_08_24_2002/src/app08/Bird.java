package app08;
/** 
* @description 鸟类（父类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月30日 下午2:11:37
* @version 1.0.0
*/
public abstract class Bird {

	//飞行方法
	public void fly(){
		System.out.println("弹射飞...");
	}
	
	//鸣叫方法
	public void shout(){
		System.out.println("嗷嗷叫...");
	}
	
	//攻击
	public abstract void attack();
}
