## 9月30日笔记 2002 34节

## 1.回顾

1. LIKE模糊查询

   1. %：代表0个或多个字符
   2. _：代表单个字符

2. 聚合函数

   1. SUM函数：求和
   2. AVG函数：求平均
   3. MAX：求最大值
   4. MIN：求最小值
   5. COUNT：求总记录数

   ## 2.DQL语言

   **聚合函数**

   COUNT()：求总记录数

   需求：查询学生表的总记录数

   ```sql
   -- 需求：查询学生表的总记录数 效率低
   SELECT COUNT(*) FROM student;
   ```

   使用一个效率高的方式，COUNT(字段)

   ```sql
   -- 使用一个效率高的方式，COUNT(字段) 
   SELECT COUNT(age) FROM student; -- 数据不准确
   ```

   <font color="red">注：count()函数统计的数量不包含null的数据，即使用count()统计表的记录数，要使用不包含null值的字段</font>

   ```sql
   SELECT COUNT(id) FROM student;
   ```

   **分页查询**

   LIMIT [m,]n 或 LIMIT n OFFSET m，第一种推荐使用

   1. 限制SELECT返回结果的行数

   2. 制定第一个返回记录行的偏移量

   3. 制定返回记录行的最大数目

   <font color="red">注：m不指定则偏移量为0，从第一条开始返回前n条记录</font>

   ***LIMIT关键字用于MySQL分页查询***

   m：当前页（起始行）

   n：每页显示多少条（容量）

   分页查询的sql：

   ```sql
   SELECT * FROM 表名 LIMIT (当前页-1)*容量,容量;
   ```

   需求：查询第1,2条记录（第一页的数据）

   ```sql
   -- 需求：查询第1,2条记录（第一页的数据）
   SELECT * FROM student LIMIT 0,2;
   -- 另一种写法
   SELECT * FROM student LIMIT 2;
   ```

   需求：查询第3,4条记录（第二页的数据）

   ```sql
   -- 需求：查询第3,4条记录（第二页的数据）
   SELECT * FROM student LIMIT 2,2;
   ```

   需求：查询第5,6条记录（第三页的数据）

   ```sql
   -- 需求：查询第5,6条记录（第三页的数据）
   SELECT * FROM student LIMIT 4,2;
   ```

   需求：查询第7,8条记录(第四页的数据)

   ```sql
   -- 需求：查询第7,8条记录(第四页的数据)
   SELECT * FROM student LIMIT 6,2;
   ```

   <font color="red">注：如果没有数据，则不显示</font>

   总页数=总记录数%容量？总记录数/容量:总记录/容量+1；

   起始行(m)=（当前页-1）*容量（n）

   **ODER BY排序**

   1. 对SELECT语句查询得到的结果，按某些字段进行排序

   2. 与DESC或ASC搭配使用，默认为ASC

   asc：顺序，正序。数值：递增，字母：自然顺序(a-z)

   desc：倒序，反序。数值：递减，字母：自然反序（z-a）

   语法：

   ```sql
   SELECT 字段1,字段2,字段n... FROM 表名 ORDER BY 字段x asc/desc;
   ```

   ```sql
   -- 插入测试数据
   INSERT INTO student(id,NAME) VALUES(2,'李四');
   SELECT * FROM student;
   ```

   <font color="red">注：默认情况下按照插入记录顺序排序</font>

   需求：按照id顺序排序

   ```sql
   -- 需求：按照id顺序排序
   SELECT * FROM student ORDER BY id ASC;
   SELECT * FROM student ORDER BY id; -- 默认为正序
   SELECT * FROM student ORDER BY id DESC; -- 反序
   ```

   需求：按照servlet正序，按照jsp反序

   ```sql
   -- 需求：按照servlet正序，按照jsp反序
   SELECT * FROM student ORDER BY servlet ASC,jsp DESC;
   ```

   

   

