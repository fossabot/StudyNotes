# 8月28日笔记 2002 1234节
## 1. 回顾 [[Java 8.27 笔记]]

1. **方法重载之构造方法重载**

	 1. 构造方法：与类同名且无返回值
	 2. 方法重载：在一个类中，方法名相同而参数不同

2. **封装**

 	1. 隐藏实现细节（属性私有化），提供公共的设置和获取的方法（get/set）
 	2. 编写了打印学生数组中每个学生的年龄

3. **学习引用数据类型数组*

 	1. 使用常规的方式 （对象名.属性名，对象名.方法名）
 	2. 使用了构造方法重载的这样的方式（简便，创建对象和为属性赋值一起完成了）
 	3. 使用封装的方法对该案例进行了进一步的改造

## 2.继承

> 为什么需要继承？
![[继承类图.png]]

**第一版**

```java
package app07;
/** 
* @description 宠物类（父类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午8:27:21
* @version 1.0.0
*/
public class Pet {
  
 //宠物名称
 private String name = "无名氏";
 //宠物健康值
 private int health = 100;
 //宠物亲密度
 private int love = 20;
 //无参构造方法
 public Pet(){}
 //有参构造方法
 public Pet(String name){
 this.name = name;
 }
  
 public String getName() {
 return name;
 }
  
 public void setName(String name) {
 this.name = name;
 }

 public int getHealth() {
 return health;
 }
  
 public void setHealth(int health) {
 this.health = health;
 }
  
 public int getLove() {
 return love;
 }
  
 public void setLove(int love) {
 this.love = love;
 }
 //打印方法（宠物的自白）
 public void print(){
 System.out.println("宠物的自白：\n"
 + "宠物的名字：" + this.name
 + "\t宠物的健康值" + this.health
 + "\t宠物的亲密度" + this.love);
 }
}

```

```java
package app07;
/** 
* @description 狗狗类（子类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:00:08
* @version 1.0.0
*/
public class Dog extends Pet {
  
 //狗狗的品种
 private String Strain = "牧羊犬";
 //无参构造方法
 public Dog(){}
  
 public String getStrain() {
 return Strain;
 }
  
 public void setStrain(String strain) {
 Strain = strain;
 }
}
```

```java
package app07;
/** 
* @description 企鹅类（子类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:05:43
* @version 1.0.0
*/
public class Penguin extends Pet {
  
 //宠物的性别
 private String sex = "Q妹";
 //无参构造方法
 public Penguin(){}
  
 public String getSex() {
 return sex;
 }
  
 public void setSex(String sex) {
 this.sex = sex;
 }
}
```

```java
package app07;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:11:44
* @version 1.0.0
*/
public class PetTest {
  
 public static void main(String[] args) {
 //实例化宠物对象
 Pet pet = new Pet("贝贝");
 //调用方法
 pet.print();
 //实例化狗狗对象
 Dog dog = new Dog();
 //调用方法(父类)
 dog.print();
 //实例化企鹅对象
 Penguin penguin = new Penguin();
 //调用方法
 penguin.print();
 }
}
```

> Dog或Penguin的print()需要和Pet中的print()有不同的实现，怎么办？

**方法重写**

概念：子类重写父类方法即可（方法重写：在子类中根据需求对从父类继承的方法进行重新编写），如：doGet、doPost

方法重写需要注意的事项

1. 重写方法和被重写方法必须具有==相同的方法名==和==参数列表==

2. 重写方法的返回值类型必须与被重写方法的==返回值类型相同==或是其==子类==

3. 重写方法不能缩小被重写方法的==访问权限==（重要）

**第二版**

```java
package app07;
/** 
* @description 宠物类（父类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午8:27:21
* @version 1.0.0
*/
public class Pet {
  
 //宠物名称
 private String name = "无名氏";
 //宠物健康值
 private int health = 100;
 //宠物亲密度
 private int love = 20;
 //无参构造方法
 public Pet(){}
 //有参构造方法
 public Pet(String name){
 this.name = name;
 }
  
 public String getName() {
 return name;
 }
  
 public void setName(String name) {
 this.name = name;
 }
  
 public int getHealth() {
 return health;
 }
  
 public void setHealth(int health) {
 this.health = health;
 }
  
 public int getLove() {
 return love;
 }
  
 public void setLove(int love) {
 this.love = love;
 }
 //打印方法（宠物的自白）
 public void print(){
 System.out.println("宠物的自白：\n"
 + "宠物的名字：" + this.name
 + "\t宠物的健康值" + this.health
 + "\t宠物的亲密度" + this.love);
 }
}
```

```java
package app07;
/** 
* @description 狗狗类（子类）
* @author 李洋 
* @address 辽冶金职业技术学院
* @created 2021年8月28日 上午9:00:08
* @version 1.0.0
*/

public class Dog extends Pet {
  
 //狗狗的品种
 private String Strain = "牧羊犬";
 //无参构造方法
 public Dog(){}
  
 public String getStrain() {
 return Strain;
 }
  
 public void setStrain(String strain) {
 Strain = strain;
 }
 //方法重写 注解
 @Override
 public void print() {
 System.out.println("狗狗的品种为：" + this.Strain);
 }
}

```

```java
package app07;
/** 
* @description 企鹅类（子类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:05:43
* @version 1.0.0
*/
public class Penguin extends Pet {
  
 //宠物的性别
 private String sex = "Q妹";
 //无参构造方法
 public Penguin(){}
  
 public String getSex() {
 return sex;
 }
  
 public void setSex(String sex) {
 this.sex = sex;
 }
 //方法重写 public 默认 protected private
 @Override
 public void print() {
 System.out.println("企鹅的性别为：" + this.sex);
 }
}
```

```java
package app07;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:11:44
* @version 1.0.0
*/
public class PetTest {
  
 public static void main(String[] args) {
 //实例化宠物对象
 Pet pet = new Pet("贝贝");
 //调用方法
 pet.print();
 //实例化狗狗对象
 Dog dog = new Dog();
 //调用方法(父类)
 dog.print();
 //实例化企鹅对象
 Penguin penguin = new Penguin();
 //调用方法
 penguin.print();
 }
}
```

**super关键字**

> Dog或Penguin如何访问Pet的成员？

 - this关键字与super关键字

	1. this关键字指代是==本类对象==

	2. super关键字指代的是==父类对象==

**super关键字的用法**

1. super关键字调用构造方法

 ```java
 super()/super(参数)
 ```

2. super关键字调用父类成员属性

 ```java
 super.属性名
 ```
3. super关键字调用父类成员方法

 ```java
 super.方法名
 ```

**第三版**

```java
package app07;
/** 
* @description 宠物类（父类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午8:27:21
* @version 1.0.0
*/
public class Pet {
  
 //宠物名称
 private String name = "无名氏";
 //宠物健康值
 private int health = 100;
 //宠物亲密度
 private int love = 20;
 //无参构造方法
 public Pet(){}
 //有参构造方法
 public Pet(String name){
 this.name = name;
 }
  
 public String getName() {
 return name;
 }
  
 public void setName(String name) {
 this.name = name;
 }
  
 public int getHealth() {
 return health;
 }

 public void setHealth(int health) {
 this.health = health;
 }
  
 public int getLove() {
 return love;
 }
  
 public void setLove(int love) {
 this.love = love;
 }
 //打印方法（宠物的自白）
 public void print(){
 System.out.println("宠物的自白：\n"
 + "宠物的名字：" + this.name
 + "\t宠物的健康值" + this.health
 + "\t宠物的亲密度" + this.love);
 }
}
```

```JAVA
package app07;
/** 
* @description 狗狗类（子类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:00:08
* @version 1.0.0
*/
public class Dog extends Pet {
  
 //狗狗的品种
 private String strain = "牧羊犬";
 //无参构造方法
 public Dog(){}
 //有参构造方法
 public Dog(String name,String strain){
 //调用父类的构造方法
 super(name);
 this.strain = strain;
 }
  
 public String getStrain() {
 return strain;
 }
  
 public void setStrain(String strain) {
 this.strain = strain;
 }
 //方法重写 注解
 @Override
 public void print() {
 //调用父类的成员方法
 super.print();
 System.out.println("狗狗的品种为：" + this.strain);
 }
}
```

```java
package app07;
/** 
* @description 企鹅类（子类）
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:05:43
* @version 1.0.0
*/
public class Penguin extends Pet {
  
 //宠物的性别
 private String sex = "Q妹";
 //无参构造方法
 public Penguin(){}
 //有参构造方法
 public Penguin(String name,String sex){
 //调用父类的构造方法
 super(name);
 this.sex = sex;
 }
  
 public String getSex() {
 return sex;
 }
  
 public void setSex(String sex) {
 this.sex = sex;
 }
 //方法重写 public 默认 protected private
 @Override
 public void print() {
 //调用父类的成员方法
 super.print();
 System.out.println("企鹅的性别为：" + this.sex);
 }
}
```

```java
package app07;
/** 
* @description 测试类
* @author 李洋 
* @address 辽宁冶金职业技术学院
* @created 2021年8月28日 上午9:11:44
* @version 1.0.0
*/
public class PetTest {
  
 public static void main(String[] args) {
 //实例化宠物对象
 Pet pet = new Pet("贝贝");
 //调用方法
 pet.print();
 //实例化狗狗对象
 Dog dog = new Dog("旺仔", "泰迪");
 //调用方法
 dog.print();
 //实例化企鹅对象
 Penguin penguin = new Penguin("腾讯", "Q仔");
 //调用方法
 penguin.print();
 //实例化宠物对象
 //Pet pet = new Pet("贝贝");
 //调用方法
 //pet.print();
 //实例化狗狗对象
 //Dog dog = new Dog();
 //调用方法(父类)
 //dog.print();
 //实例化企鹅对象
 //Penguin penguin = new Penguin();
 //调用方法
 //penguin.print();
 }
}
```

## 3.多态
  
多态：一种类型，不同的形态，即同一引用类型，使用不同的实例，而执行不同操作
  
> 如下主人类中给宠物看病的方法，如果又需要给XXX宠物看病，怎么办
  
需要使用多态
  
多态应用：父类作为方法的形参