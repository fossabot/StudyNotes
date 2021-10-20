package app09;
/** 
* @description 风扇类（实现类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午9:07:31
* @version 1.0.0
*/
public class USBFanImpl implements PowerSupply {

	//Fn+f2
	@Override
	public void powerSupply() {
		System.out.println("电扇开始转动了...");
	}
}
