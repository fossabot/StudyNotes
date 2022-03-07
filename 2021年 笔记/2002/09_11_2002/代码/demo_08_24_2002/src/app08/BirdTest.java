package app08;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月30日 下午2:34:15
* @version 1.0.0
*/
public class BirdTest {

	public static void main(String[] args) {
		//实例化分裂鸟对象，父类引用指向子类对象
		Bird splitBird = new SplitBird();
		//调用飞行方法
		splitBird.fly();
		//调用鸣叫方法
		splitBird.shout();
		//调用攻击方法
		splitBird.attack();
		//实例化火箭鸟
		Bird rocketBird = new RocketBird();
		//调用飞行方法
		rocketBird.fly();
		//调用鸣叫方法
		rocketBird.shout();
		//调用攻击方法
		rocketBird.attack();
	}
}
