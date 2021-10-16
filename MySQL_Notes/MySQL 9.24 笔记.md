# 9月24日笔记 2002 78节

## 1.回顾 [[MySQL 9.23 笔记]]

1. 按条件查询
   1. AND、OR、NOT
   2. \>=、<=、<>
   3. BETWEEN...AND关键字
2. NULL
   1. 没有值
   2. IS NULL
   3. IS NOT NULL

## 2.DQL(数据查询语言)

**判空条件（NULL VS 空字符）**

区别

1. null表示没有值
2. 空字符串是有值的

需求：查询地址为空的学生（包括NULL和空字符串）

```sql
-- 插入测试数据
INSERT INTO student VALUES(4,'陈六','男',28,75,80,'');
INSERT INTO student VALUES(5,'李七','男',30,64,83,NULL);
-- 需求：查询地址为空的学生（包括NULL和空字符串）
SELECT * FROM student WHERE address IS NULL;
-- 判断空字符串
SELECT * FROM student WHERE address='';
-- 包括NULL和空字符串
SELECT * FROM student WHERE address IS NULL OR address='';
```

需求：查询有地址的学生（不包括null或空字符串）

```sql
-- 需求：查询有地址的学生（不包括null或空字符串）
SELECT * FROM student WHERE address IS NOT NULL AND address<>'';
```

**LIKE（模糊查询）**

LIKE模糊查询查询数据库数据，如SELECT语句

只能与“%”与“_”

1. 与“%”一起使用，表示匹配0或任意多个字符

2. 与“_”一起使用，表示匹配单个字符

需求：查询姓李的学生

```sql
-- 需求：查询姓李的学生
SELECT * FROM student WHERE NAME LIKE '李%';
```

需求：查询姓李，且名字只有两个字的学生

```sql
-- 需求：查询姓李，且名字只有两个字的学生
SELECT * FROM student WHERE NAME LIKE '李_';
```

需求：查询姓名中有李的学生

```sql
-- 需求：查询姓名中有李的学生
SELECT * FROM student WHERE NAME LIKE '%李%';
```

需求：查询姓李，且名字只有三个字的学生

```sql
-- 需求：查询姓李，且名字只有三个字的学生
SELECT * FROM student WHERE NAME LIKE '李__';
```

**MySQL统计函数**

| **函数名称**   | **描述**                                               |
| -------------- | ------------------------------------------------------ |
| **COUNT( )**   | 返回满足SELECT条件的记录总和数，如 SELECT COUNT(*)..   |
| **SUM( )**     | 返回数字字段或表达式列作统计，返回一列的总和           |
| **AVG(** **)** | 通常为数值字段或表达列作统计，返回一列的平均值         |
| **MAX( )**     | 可以为数值字段、字符字段或表达式列作统计，返回最大的值 |
| **MIN( )**     | 可以为数值字段、字符字段或表达式列作统计，返回最小的值 |

聚合查询（使用聚合函数的查询）

需求：查询学生的Servlet的总成绩

```sql
-- 需求：查询学生的Servlet的总成绩
SELECT SUM(servlet) AS 'servlet的总成绩' FROM student;
```

需求：查询学生servlet的平均分

```sql
-- 需求：查询学生servlet的平均分
SELECT AVG(servlet) AS 'servlet的平均分' FROM student;
```

需求：查询学生servlet的最高分

```sql
-- 需求：查询学生servlet的最高分
SELECT MAX(servlet) AS 'servlet的最高分' FROM student;
```

需求：查询学生servlet的最低分

```sql
-- 需求：查询学生servlet的最低分
SELECT MIN(servlet) AS 'servlet的最低分' FROM student;
```

需求：查询当前有多少个学生

```sql
-- 需求：查询当前有多少个学生
SELECT COUNT(*) FROM student;
```



