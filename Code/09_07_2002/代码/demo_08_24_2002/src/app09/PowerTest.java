package app09;
/** 
* @description 测试
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午9:29:04
* @version 1.0.0
*/
public class PowerTest {

	public static void main(String[] args) {
		//实例化风扇类，父类应用指向子类对象
		PowerSupply usbFan = new USBFanImpl();
		//调用方法
		usbFan.powerSupply();
		//实例化鼠标类
		PowerSupply usbMouse = new USBMouseImpl();
		//调用方法
		usbMouse.powerSupply();
		//实例化U盘
		PowerSupply usbDisk = new USBDiskImpl();
		//调用方法
		usbDisk.powerSupply();
	}
}
