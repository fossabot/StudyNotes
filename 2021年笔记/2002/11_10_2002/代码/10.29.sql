USE db_2002;
-- 准备测试数据
DROP TABLE IF EXISTS salary_table;
CREATE TABLE salary_table(
	id INT PRIMARY KEY AUTO_INCREMENT,
	POSITION VARCHAR(20),
	salary INT
);
INSERT INTO salary_table(POSITION,salary) VALUES('Java',8000),('Java',8400),
('Java',9000),('Python',6500),('Python',10000),('Python',8900);
SELECT * FROM salary_table;
-- 需求：查询薪水比岗位为Python薪水高的数据
SELECT *
FROM salary_table st
WHERE st.`salary`>
SOME(SELECT st.`salary`
FROM salary_table st
WHERE st.`position`='Python');
-- 需求：查询薪水比==所有==岗位为Python的薪水高的数据
SELECT *
FROM salary_table st
WHERE st.`salary`>
ALL(SELECT st.`salary`
FROM salary_table st
WHERE st.`position`='Python');
-- 需求：如果能够查询出有岗位为Python的数据，那么查询新水表的所有数据
SELECT * FROM salary_table WHERE
EXISTS(SELECT * 
FROM salary_table st 
WHERE st.position='Python');
-- 需求：如果能够查询出有岗位为C语言的数据，那么查询新水表的所有数据
SELECT * FROM salary_table WHERE
EXISTS(SELECT * FROM salary_table st
WHERE st.position='C语言');
-- ---------------------------------------
SELECT * FROM salary_table WHERE
NOT EXISTS(SELECT * FROM salary_table st
WHERE st.position='C语言');

