# 8月23日笔记 2002 56节

##  1. 介绍新的IDE
 - eclipse（免费）在IDEA没有兴起之前，Java开发人员最为常用的IDE

### eclipse的安装

*1. 配置JDK环境*

- 安装jdk 1.8
- 配置Java环境变量
- JAVA_HOME（新建）：JDK的安装目录
- Path（编辑）：%JAVA_HOME%bin;
- 检测jdk是否安装成功，使用java -version命令检测jdk是否安装成功

*2. 安装eclipse*
 - 解压对应的压缩包并发送 <font color="blue">快捷方式</font> 到你的桌面上
 - 设定Workspace目录为你能找到的目录

## 2. Java回顾

### 第一章 初识Java

*主函数*

```java
public static void main(String[] arg){
 System.out.println("Hello World");
}
```

\n（换行符）、\t（水平制表符）


### 第二章 Java的数据类型及运算符

Java中的数据类型分为基本数据类型和引用数据类型，基本数据类型分为四类八种数据类型

四类：整型（int）、浮点型（double）、字符型（char）、布尔型（boolean）

八种：长整型（long）、普通整型（int）、短整型（short）、字节（byte）

​ 双精度浮点型（double）、float（单精度浮点型）、char（字符型）
​ 布尔型（boolean）

<font color="red">注：String类型为Java中的引用数据类型</font> 

运算符：+、-、*、=、...

输入输出：`Scanner input = new Scanner(System.in);`

*1. 强制类型转换*

```java
double num = 9.8;
int num1 = (int)num; //强制类型转换=>9
```

<font color="red">注：强制类型转换方便进行计算，但是确损失了精度</font>

*2. 布尔值（true/false）*

```java
int baiyangScore = 98;
int guojunScore = 96;
//两者进行分数比较
boolean isHigh = baiyangScore > guojunScore; //true
```


### 第三章 if选择结构-1
*1. 单if选择结构*  

```java
if(条件，必须为boolean值){
 //代码
}
```

*2. if-else选择结构*

```java
if(条件){
 //代码
}else{
 //代码
}
```

*3. 多分支if选择结构*

```java
if(条件){
 //代码
}else if(条件){
 //代码
}
... //else if可以有多个
else{
 //代码
} 
```

*4. 嵌套if选结构*  

```java
if(条件，判断跑步成绩是否在10s内){
 if(条件，性别为男){
 //代码 进入男子组
 }else{
 //代码 进入女子组
 } 
}else{
 //代码 淘汰
}
```
