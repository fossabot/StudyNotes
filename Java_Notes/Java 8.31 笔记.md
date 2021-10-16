# 8月31日笔记 2002 12节
## 1.回顾 [[Java 8.30 笔记]]

1. 普通类与抽象类的区别

 1. 抽象类使用abstract关键字修饰

 2. 抽象类中可以抽象方法也可以有普通方法

 3. 抽象类不能被实例化

2. 普通方法与抽象方法的区别

 1. 抽象方法只能有方法的声明

 2. 抽象方法必须使用abstract关键字修饰

 3. 抽象方法必须放在抽象类中

## 2.接口

> 生活中的接口？

**生活中的接口是指某些企业和组织等制定的一种 ==约定== 或 ==标准== **

**Java中的接口**

概念：Java 中的接口提供一种 ==约定== ，使得实现接口的类在形式上保持一致


```java
public interface 接口名{
	 //抽象方法
}
```

```java
public class 类名 implements 接口名{
	 //实现接口中的方法
	 //普通方法
}
```

<font color="red">注：一个类实现接口必须实现这个接口的所有（抽象）方法</font>

**抽象类VS接口**

1. 抽象类必须使用abstract关键字声明，而接口使用interface关键字声明

2. 抽象类中可以有抽象方法也可以有普通方法，而接口只能有抽象方法（==无须使用abstract关键字修饰==）

3. 接口和抽象类均不能被实例化

```java
package app09;
/** 
* @description 供电接口
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午8:58:24
* @version 1.0.0
*/
public interface PowerSupply {
  
	 //供电方法，完整写法
	 //public abstract void powerSupply();
	 //接口中public abstract可以省略
	 void powerSupply();
}
```

```java
package app09;
/** 
* @description 风扇类（实现类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午9:07:31
* @version 1.0.0
*/

public class USBFanImpl implements PowerSupply {
  
	 //Fn+f2
	 @Override
	 public void powerSupply() {
	 System.out.println("电扇开始转动了...");
	 }
}
```

```java
package app09;
/** 
* @description 鼠标（实现类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午9:16:45
* @version 1.0.0
*/
public class USBMouseImpl implements PowerSupply {
  
	 @Override
	 public void powerSupply() {
	 System.out.println("USB鼠标开始工作了...");
	 }
}
```

```java
package app09;
/** 
* @description U盘（实现类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午9:24:06
* @version 1.0.0
*/
public class USBDiskImpl implements PowerSupply {
  
	 @Override
	 public void powerSupply() {
	 System.out.println("U盘开始传输数据了...");
	 }
}
```

```java
package app09;
/** 
* @description 测试
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月31日 上午9:29:04
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
```