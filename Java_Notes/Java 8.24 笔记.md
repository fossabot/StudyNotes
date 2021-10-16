#  8月24日笔记 2002
## 回顾 [[Java 8.23 笔记]]

### 第四章 switch选择结构

```java
switch(表达式(整型、字符、字符串)){
 case 1:
 //代码
 break;
 case 2:
 //代码
 break;
 case 3:
 //代码
 break;
 ...
 default:
 //代码
 break; 
}
```

<font color="red">注：多分支if选择结构用于区间判断，switch选择结构通常用于等值判断的情况</font>

### 第五章 循环结构-1 While循环

```java
//初始值
while(循环条件){
 //循环操作
 //循环增量
}
  
do{
 //循环操作
 //循环增量
}while(循环条件);
```

<font color="red">注：while循环是先判断再执行，而do-while循环是先执行再判断，while循环可以一次都不执行，而do-while循环至少执行一次</font>

### 第六章 循环结构-2 for循环结构

```java
for(初始值;循环条件;循环增量){
 if(条件){
 break;
 }
 if(条件){
 continue;
 }
 //循环操作
}
```

<font color="red">注：确定循环次数时，那么我们推荐使用for循环结构</font>

循环涉及的两个关键字

1. break：该关键字退出整个循环结构，通常与条件语句一起使用

2. continue：该关键字退出当次循环，通常与条件语句一起使用

### 第七章 数组

概念：存储 ==相同数据类型== 的容器

```java
//数组定义
//动态初始化 数据类型[] 数组名 = new 数据类型[长度];
int[] scores = new int[3];
//为元素赋值，数组下标从0开始
scores[0] = 1;
scores[1] = 2;
scores[2] = 3;
  
//数组定义
//静态初始化
//方式1：
int[] scores = new int[]{1,2,3}; //括号中一定不要写长度
//方式2：
int[] scores = {1,2,3}; //清晰元素具体有哪些，推荐使用该写法
```
数组的遍历方式：

1. 普通for遍历

2. 增强for遍历

```java
//普通for遍历
for(int i=0;i<scores.length;i++){ //scores为数组名称
 System.out.println(scores[i]); //其中i为数组的下标
}
  
//增强for遍历
for(int i:scores){
 System.out.println(i);
}
```

##  2.类和对象
 - *[[Eclipse的使用]]*