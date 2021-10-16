# 9月16日笔记 2002 1234节

## 1.回顾 [[MySQL 9.10 笔记]]

1. 插入数据（INSERT）
   1. 插入所有字段
   2. 插入部分字段
   3. ==一次插入多条语句==
2. 修改数据（UPDATE）
   1. 修改所有字段
   2. 按条件进行修改
3. 删除数据（DELETE）
   1. 删除所有字段
   2. 按条件进行删除
4. DELETE语句与TRUCATE语句的区别

```sql
-- 使用数据库
USE db_2002;
-- 查看数据表
SHOW TABLES;
-- 查看表结构
DESC student;
-- 创建test表
DROP TABLE IF EXISTS test;
CREATE TABLE test(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);
INSERT INTO test(NAME) VALUES('张三'),('李四'),('王五');
SELECT * FROM test;
-- 删除所有表数据
DELETE FROM test;
-- 删除数据表数据（TRUNCATE）
TRUNCATE TABLE test;
```

**2.DQL语言（数据查询语言）**

1. 查询数据库数据，如SELECT语句

2. 简单的单表查询或多表的复杂查询和嵌套查询

3. 数据库语言中最核心、最重要的语句

4. 使用频率最高的语句

**SELECT语句**

语法：

```sql
SELECT [ALL|DISTINCT]
{* | table.* | [table.field1] [as alias] [，table.field2 [as alias2]] [，...]}
FROM table_name [as table_alias]
[ LEFT | OUT | INNER JOIN table_name2 ] #关联查询
[ WHERE ] #指定结果满足的条件
[ GROUP BY] #结果按照哪些字段进行分组
[ HAVING ] #过滤分组记录满足的次要条件
[ ORDER BY ] #指定查询记录一个或者多个条件进行排序
[ LIMIT ] #指定查询记录从哪条到哪条（分页）
```

**查询所有列**

```sql
-- 查询所有列,效率较低
SELECT * FROM student;
-- 方式2
SELECT student.* FROM student;
```

**查询指定字段**

as子句作为别名

1. 可以给数据列起别名
2. 可以给数据表起别名
3. 可以给计算结果用另一个新名称去代替

