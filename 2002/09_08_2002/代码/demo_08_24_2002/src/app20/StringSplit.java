package app20;
/** 
* @description 字符串的分隔
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月6日 下午2:35:14
* @version 1.0.0
*/
public class StringSplit {

	public static void main(String[] args) {
		//定义字符串（歌词）
		String words = "长亭外 古道边 芳草碧连天 晚风拂 柳笛声残 夕阳山外山";
		//分隔字符串，字符串数组
		String[] split = words.split(" ");
		System.out.println("分隔后的歌词为：");
		//增强for遍历
		for (String string : split) {
			System.out.println(string);
		}
	}
}
