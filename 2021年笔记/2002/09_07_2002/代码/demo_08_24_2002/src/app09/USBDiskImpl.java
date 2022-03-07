package app09;
/** 
* @description U盘（实现类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午9:24:06
* @version 1.0.0
*/
public class USBDiskImpl implements PowerSupply {

	@Override
	public void powerSupply() {
		System.out.println("U盘开始传输数据了...");
	}
}
