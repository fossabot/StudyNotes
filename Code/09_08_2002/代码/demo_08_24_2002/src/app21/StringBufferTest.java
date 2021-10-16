package app21;
/** 
* @description StringBuffer类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年9月7日 上午8:27:22
* @version 1.0.0
*/
public class StringBufferTest {

	public static void main(String[] args) {
		//实例化StringBuffer类
		StringBuffer sb = new StringBuffer("你好");
		//追加字符串
		sb.append("再见");
		//链式调用
		sb.append("再见").append("再见");
		//插入字符串
		sb.insert(2, "不");
		System.out.println(sb.toString());
	}
}
