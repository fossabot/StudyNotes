-- 14.从student表和score表中学生的学号，然后合并查询结果
SELECT s.`id`
FROM student s
UNION
SELECT sc.`stu_id`
FROM score sc; -- 去重
-- --------------------------------------
SELECT s.`id`
FROM student s
UNION ALL
SELECT sc.`stu_id`
FROM score sc; -- 不去重
-- 15.查询姓张或姓王的同学姓名、院系、考试科目及成绩
SELECT s.`NAME`,s.`department`,sc.`c_name`,sc.`grade`
FROM student s,score sc
WHERE s.`id`=sc.`stu_id`
AND (s.`NAME` LIKE '张%' OR s.`NAME` LIKE '王%');
-- 16.查询都是湖南的学生姓名，年龄，院系，考试科目及成绩
SELECT s.`NAME`,s.`birth`,s.`department`,sc.`c_name`,sc.`grade`
FROM student s INNER JOIN score sc 
ON s.`id`=sc.`stu_id`
WHERE s.`address` LIKE '湖南%';