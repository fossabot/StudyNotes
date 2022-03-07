-- 1.查询所有学生
SELECT * FROM student;
-- 2.查询studdent表中第2到4条记录 3:容量
SELECT * FROM student LIMIT 1,3;
-- 3.从学生表查询所有学生的学号，姓名，院系
SELECT s.`id`,s.`NAME`,s.`department`
FROM 
student s;
-- --------------------------------
-- 方式二：
SELECT student.`id`,student.`NAME`,student.`department`
FROM student;
SHOW DATABASES;
-- use 数据库名;
-- show tables;
-- SET NAMES gbk;
-- SELECT * FROM student\G
-- 4.从学生表中查询计算机系和英语系的学生
-- 方式一：WHERE...OR
SELECT *
FROM student s
WHERE s.`department`='计算机系' OR s.`department`='英语系'; 
-- 方式二：IN关键字
SELECT *
FROM student s 
WHERE s.`department` IN('计算机系','英语系');
-- 5.从学生表中查询18-22岁的学生信息(2013)
SELECT s.`id`,s.`NAME`,2013-birth AS age,s.`address`
FROM student s
WHERE 2013-birth BETWEEN 18 AND 22;
-- 6.从学生表中查询每个院系有多少人
SELECT s.`department`,COUNT(s.`id`) AS '人数'
FROM student s
GROUP BY s.`department`;
-- 7.从score中查询每个科目的最高分
SELECT sc.`c_name`,MAX(sc.`grade`)
FROM score sc
GROUP BY sc.`c_name`;
-- 8.查询李四考试科目和考试成绩(子查询)
SELECT sc.`c_name`,sc.`grade`
FROM score sc
WHERE sc.`stu_id` IN
(SELECT s.`id`
FROM student s
WHERE s.`NAME`='李四');
-- 9.用连接的方式查询所有学生信息和考试信息
-- 方式一：等值连接
SELECT s.`id`,s.`NAME`,s.`department`,s.`address`,sc.`c_name`,sc.`grade`
FROM student s,score sc
WHERE s.`id`=sc.`stu_id`;
-- 方式二：INNER JOIN...ON
SELECT s.`id`,s.`NAME`,s.`department`,s.`address`,sc.`c_name`,sc.`grade`
FROM student s INNER JOIN score sc
ON s.`id`=sc.`stu_id`;
-- 10.计算每个学生的总成绩
SELECT s.`id`,s.`NAME`,SUM(sc.`grade`) AS '总成绩'
FROM student s,score sc
WHERE s.`id`=sc.`stu_id`
GROUP BY s.`id`;
-- 11.计算每个考试科目的平均成绩
SELECT sc.`c_name`,AVG(sc.`grade`) AS '平均分'
FROM score sc
GROUP BY sc.`c_name`;
-- 12.查询计算机成绩低于95分的学生信息(子查询)
SELECT s.`id`,s.`NAME`
FROM student s WHERE s.`id` IN
(SELECT sc.`stu_id`
FROM score sc
WHERE sc.`c_name`='计算机' AND sc.`grade`<95);
-- 13.将计算机考试成绩按从高到底进行排序
SELECT sc.`stu_id`,sc.`grade`
FROM score sc
WHERE sc.`c_name`='计算机'
ORDER BY sc.`grade` DESC;
