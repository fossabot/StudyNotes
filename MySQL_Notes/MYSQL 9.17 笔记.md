# MYSQL 9.17 笔记
---
## 1. 回顾 [[MySQL 9.16 笔记]]
1. `DELETE` 和 `TRUNCATE` 的区别
2. `DQL`，查询数据
3. 查询
	1. 查询所有列
	2. 查询指定列
	3. 为表起别名
---
## 2. DQL（数据查询语言）
```sql
-- 使用数据库
USE db_2002;

-- 查看所有表
SHOW TABLES;

-- 查看表结构
DESC student;

-- 查询学生表中的所有数据
SELECT * FROM student;

-- 将id为1的年龄改为20
UPDATE student SET age=20 WHERE id=1;
```
---
### 2.1 查询时指定别名
 - <font color="red">注意：在多表查询时经常使用表的别名</font>
```sql
-- 使用表别名
SELECT s.`id`,s.`name`,s.`age`,s.`gender`

-- 查询时指定别名
SELECT NAME AS '姓名',age AS '年龄' FROM student;
```
---
 - **查询时添加常量列**
 - <font color="gray">需求：</font>在查询`student`表时添加一个班级列，内容为 <u>Java大数据</u>
```sql
-- 需求：在查询 student 表时添加一个班级列，内容为Java大数据
SELECT id,NAME,gender,age.'Java大数据' AS '年级' FROM student;
```
```sql
-- 为student表添加jsp和servlet成绩
ALTER TABLE student ADD jsp INT,ADD servlet INT;

-- 查看表结构
DESC student;

-- 准备测试数据
UPDATE student SET servlet=70,jsp=85 WHERE id=1;
UPDATE student SET servlet=65,jsp=90 WHERE id=2;
SELECT * FROM student;

-- 将id为2的学生性别改为女
UPDATE student SET gender='女' WHERE id=2;
INSERT INTO student VALUES(3,'王五','男',28.75,80);

-- 调节age与gender的顺序 MODIFY 字段名，类型 AFTER/BEFORE 字段名
ALTER TABLE student MODIFY gender VARCHAR(20) AFTER age;
ALTER TABLE student MODIFY age VARCHAR(20) AFTER gender;
SELECT * FROM student;
```
---
 - **查询合并列**
 - <font color="gray">需求：</font><u>查询每个学生servlet和jsp的总成绩。</u>
```sql
SELECT id,NAME,(jsp+servlet) AS '总成绩' FROM student;
-- 注意：合并列只能合并数值类型的字段
-- select (name+servlet) from student;
```
---
 - 查询时去除重复记录 `DISTINCT`
 - <font color="gray">作用：</font>去掉 `SELECT` 查询返回的记录结果中重复的记录（所有返回列的值都相同），只返回一条。
```sql
-- 需求：查询学生性别
SELECT DISTINCT gender FROM student;

-- 另一种语法
SELECT DISTINCT(gender) FROM student;
```

```sql
-- 添加字段
ALTER TABLE student ADD address VARCHAR(10);
DESC student;
```

```sql
-- 添加测试数据
UPDATE student SET address='沈阳大东' WHERE id=1;
UPDATE student SET address='沈阳大东' WHERE id=2;
UPDATE student SET address='沈阳沈河' WHERE id=3;
SELECT * FROM student;
```
---