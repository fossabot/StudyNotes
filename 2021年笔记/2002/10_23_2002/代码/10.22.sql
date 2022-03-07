USE db_2002;
-- 预期结果见笔记
-- 需求：使用右外连接的方式完成上面的预期结果
SELECT d.`deptName`,e.`empName`
FROM employee e RIGHT OUTER JOIN dept d
ON d.`id`=e.`deptId`;
-- 准备测试数据
SELECT * FROM employee;
-- 添加上司字段
ALTER TABLE employee ADD bossId INT;
-- 设置部门领导
UPDATE employee SET bossId=1 WHERE id=2;
UPDATE employee SET bossId=2 WHERE id=3;
UPDATE employee SET bossId=3 WHERE id=4;
-- 需求：查询员工及其上司
SELECT e.`empName`,b.`empName`
FROM employee e LEFT OUTER JOIN employee b
ON e.`bossId`=b.`id`;
-- 需求：查询部门名称为软件开发部和秘书部的部门信息（子查询的前提）
-- 方式一：使用IN关键字
SELECT * FROM dept d WHERE d.`deptName` IN('软件开发部','秘书部');
-- 方式二：使用WHERE...OR
SELECT * FROM dept d WHERE d.`deptName`='软件开发部' 
OR d.`deptName`='秘书部'; 
-- 需求：查询在软件开发部的员工的姓名
-- 子查询：当一个查询是另一个查询的条件时，称之为子查询
SELECT e.`empName`
FROM 
employee e 
WHERE e.`deptId` =
(SELECT d.`id` 
FROM dept d 
WHERE d.`deptName`='软件开发部');

SELECT e.`empName`
FROM 
employee e 
WHERE e.`deptId` =
(SELECT d.`id` 
FROM dept d 
WHERE d.`deptName`='软件开发部' OR d.`deptName`='秘书部');