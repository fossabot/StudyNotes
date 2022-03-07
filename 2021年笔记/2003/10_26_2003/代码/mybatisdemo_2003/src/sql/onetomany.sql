DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `students_teachers_fk` (`tid`),
  CONSTRAINT `students_teachers_fk` FOREIGN KEY (`tid`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `students`(`id`,`name`,`tid`) values (1,'张三',1),(2,'李四',1),(3,'王五',1),(4,'陈六',1),(5,'李七',1);


DROP TABLE IF EXISTS `teachers`;

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `teachers`(`id`,`name`) values (1,'李老师');


