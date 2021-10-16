USE homework_2002;
CREATE TABLE student2(
	id INT,
	NAME VARCHAR(20),
	chinese FLOAT,
	english FLOAT,
	math FLOAT
);
INSERT INTO student2(id,NAME,chinese,english,math) VALUES(1,'张小明',89,78,90);
INSERT INTO student2(id,NAME,chinese,english,math) VALUES(2,'李进',67,53,95);
INSERT INTO student2(id,NAME,chinese,english,math) VALUES(3,'王五',87,78,77);
INSERT INTO student2(id,NAME,chinese,english,math) VALUES(4,'李一',88,98,92);
INSERT INTO student2(id,NAME,chinese,english,math) VALUES(5,'李来财',82,84,67);
INSERT INTO student2(id,NAME,chinese,english,math) VALUES(6,'张进宝',55,85,45);
INSERT INTO student2(id,NAME,chinese,english,math) VALUES(7,'黄蓉',75,65,30);
SHOW TABLES;
-- 1.查询表中所有学生的信息。
SELECT * FROM student2;
-- 2.查询表中所有学生的姓名和对应的英语成绩。
SELECT NAME,english FROM student2;
-- 3.过滤表中英语成绩的重复数据
SELECT DISTINCT(english) FROM student2;
-- 4.使用别名表示学生分数。
SELECT NAME AS '姓名',chinese AS '语文',english AS '英语',math AS '数学' FROM student2;
-- 5.查询姓名为李一的学生成绩
SELECT * FROM student2 WHERE NAME='李一';
-- 6.查询英语成绩大于等于90分的同学
SELECT * FROM student2 WHERE english>=90;
-- 7.查询总分大于200分的所有同学
SELECT * FROM student2 WHERE (chinese+english+math)>200;
-- 8.查询所有姓李的学生英语成绩。
-- 悬念（模糊查询）
-- 9.查询英语>80或者总分>200的同学
SELECT * FROM student2 WHERE english>80 OR (chinese+english+math)>200;
-- 10.统计每个学生的总分
SELECT id,NAME,(chinese+english+math) AS '总成绩' FROM student2;
-- 11.在所有学生总分数上加10分特长分。
SELECT id,NAME,(chinese+english+math+10) AS '总成绩' FROM student2;