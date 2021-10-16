package app23;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
* @description 日期时间格式化
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月7日 上午9:13:56
* @version 1.0.0
*/
public class DateFormatTest {

	public static void main(String[] args) {
		//实例化时间对象
		Date d = new Date();
		//System.out.println(d);
		//实例化日期时间格式化类 24小时制
		/*SimpleDateFormat sdf = new 
				SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
		//实例化日期时间格式化类 12小时制
		SimpleDateFormat sdf = new 
				SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//格式化日期
		String format = sdf.format(d);
		System.out.println(format);
	}
}
