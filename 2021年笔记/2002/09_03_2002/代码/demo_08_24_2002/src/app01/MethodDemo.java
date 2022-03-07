package app01;
/** 
* @description 类的方法
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月24日 上午9:34:17
* @version 1.0.0
*/
public class MethodDemo {

	//无返回值无参
	public static void noParam(){
		System.out.println("大数据2班需要加油了");
	}
	
	//有返回值无参
	public static String returnParam(){
		return "大数据2班威武霸气";
	}
	
	//无返回值有参
	public static void noReturn(String food){
		System.out.println("猴子爱吃" + food);
	}
	
	//有返回值有参
	public static int add(int a,int b){
		return a+b;
	}
	
	public static int add(int a,int b,int c){
		return a+b+c;
	}
	
	//可变参数
	public static int add(int a,int...obj){
		int sum = a;
		for(int i=0;i<obj.length;i++){
			//循环累加
			sum += obj[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int add = add(1,2,3,4,5,6);
		System.out.println(add);
		
		//int add = add(1,2);
		//System.out.println(add);
		
		//noReturn("香蕉");
		//调用有返回值方法
		//方式1：打印输出法
		//System.out.println(returnParam());
		//方式2：变量接收法 ctrl+1
		//String returnParam = returnParam();
		//System.out.println(returnParam);
		
		//调用方法
		//noParam();
	}
}
