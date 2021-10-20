package app17;

import java.util.Scanner;

/** 
* @description String类的equals()方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月4日 上午10:33:22
* @version 1.0.0
*/
public class StringEquals {

	public static void main(String[] args) {
		//实例化扫描仪对象（Scanner）
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = input.next();
		System.out.println("请输入密码：");
		String password = input.next();
		//登录验证
		if("TOM".equals(username)&&
				"1234567".equals(password)){
			System.out.println("登录成功...");
		}else{
			System.out.println("用户名或密码错误...");
		}
		//关闭资源
		input.close();
	}
}
