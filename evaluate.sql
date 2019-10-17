# Host: localhost  (Version 5.7.22)
# Date: 2019-10-17 08:48:30
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "classes"
#

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classes_no` varchar(20) DEFAULT NULL COMMENT '班级号',
  `dep_id` int(11) DEFAULT NULL COMMENT '院系id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8 COMMENT='班级表';

#
# Data for table "classes"
#

INSERT INTO `classes` VALUES (30,'1690001',5),(31,'1690002',5),(32,'1690003',5),(33,'1690004',5),(34,'1690005',5),(35,'1690006',5),(36,'1690007',5),(37,'1690008',5),(38,'1590001',6),(39,'1590003',6),(40,'1590002',6),(41,'1590004',6),(42,'1590005',6),(43,'1790001',7),(44,'1790002',7),(45,'1790003',7);

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(30) DEFAULT NULL COMMENT '课程名称',
  `dep_id` int(11) DEFAULT NULL COMMENT '院系id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='系别课程表';

#
# Data for table "course"
#

INSERT INTO `course` VALUES (6,'Java Web',5),(7,'项目管理',5),(8,'市场营销',6),(9,'管理经济学',6),(10,'高层建筑设计',7),(11,'建筑工程CAD',7),(12,'计算机组成原理',5),(13,'C++',5),(14,'软件工程',5),(15,'面向对象程序设计',5),(16,'客户端开发技术',5),(17,'HTML5+CSS3',5),(18,'数据结构',5),(19,'mysql数据库原理',5),(20,'财务管理',6),(21,'消费者心理学',6),(22,'经济学',6),(23,'酒店管理',6),(24,'结构力学',7),(25,'工程测量',7),(26,'材料力学',7),(27,'混泥土结构',7);

#
# Structure for table "department"
#

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(50) DEFAULT NULL COMMENT '系别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='院系表';

#
# Data for table "department"
#

INSERT INTO `department` VALUES (5,'软件学院'),(6,'管理学院'),(7,'土木学院');

#
# Structure for table "manage"
#

DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL COMMENT '账号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

#
# Data for table "manage"
#

INSERT INTO `manage` VALUES (1,'123','123');

#
# Structure for table "norm"
#

DROP TABLE IF EXISTS `norm`;
CREATE TABLE `norm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standard_id` int(11) DEFAULT NULL COMMENT '评教指标id',
  `norm_con` varchar(50) DEFAULT NULL COMMENT '选项内容',
  `norm_score` int(5) DEFAULT NULL COMMENT '选项分数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

#
# Data for table "norm"
#

INSERT INTO `norm` VALUES (1,1,'语言精炼，深入浅出',5),(2,1,'讲解清晰',3),(3,1,'169000801',2),(4,1,'概念紊乱',1),(5,2,'重点突出，讲清难点，举一反三',5),(6,2,'能把握重点、难点，但讲解不够明确',3),(7,2,'重点不明显，难点讲不透',2),(8,2,'重点一言而过，难点草率了事',1),(9,3,'层次分明，融会贯通 ',5),(10,3,'条目较清楚，有分析归纳',3),(11,3,'平淡叙述，缺乏连贯性',2),(12,3,'杂乱无章，前后矛盾',1),(13,4,'讲解方法新颖，举例生动，有吸引力',5),(14,4,'讲解较熟练，语言通俗',3),(15,4,'讲解平淡，语言单调',2),(16,4,'讲解生疏，远离课题，语言枯燥',1),(17,5,'简繁适度，清楚醒目',5),(18,5,'条目明白，书写整洁',3),(19,5,'布局较差，详略失当',2),(20,5,'次序凌乱，书写潦草',1),(21,6,'辅导及时、并指导课外阅读',5),(22,6,'定期辅导，并布置课外阅读',3),(23,6,'辅导较少',2),(24,6,'没有辅导',1),(25,7,'选题得当，批改及时，注意讲评 ',5),(26,7,'作业适量，批改及时',3),(27,7,'作业量时轻时重，批改不够及时',2),(28,7,'选题随便，批改马虎',1),(29,8,'思路开阔，鼓励创新，注意能力培养、效果明显',5),(30,8,'注意学生能力培养，并在教学中有所体现',3),(31,8,'能提出能力培养的要求，但缺乏具体的办法',2),(32,8,'注意学生能力培养，并在教学中有所体现',1),(33,9,'全面关心学生，经常接触学生，亲切、严格',5),(34,9,'关心学生的学业，引导学生学好本门课程',3),(35,9,'单纯完成上课任务，与同学接触较少',2),(36,9,'对学生漠不关心，放任自流',1),(37,10,'严于律己，以身作则，堪称楷模',5),(38,10,'举止文明，待人热情',3),(39,10,'注意礼貌，待人和气',2),(40,10,'要求不严，言谈失当',1),(41,11,'优秀',5),(42,11,'良好',3),(43,11,'一般',2),(44,11,'较差',1),(45,12,'优秀',5),(46,12,'良好',3),(47,12,'一般',2),(48,12,'较差',1),(49,13,'优秀',5),(50,13,'良好',3),(51,13,'一般',2),(52,13,'较差',1);

#
# Structure for table "st_score"
#

DROP TABLE IF EXISTS `st_score`;
CREATE TABLE `st_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生评价分数表id',
  `student_id` int(11) DEFAULT NULL COMMENT '学生id',
  `classes_id` int(11) DEFAULT NULL COMMENT '班级id',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师id',
  `st_score` float(5,2) DEFAULT NULL COMMENT '学生评分',
  `course_name` varchar(30) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='评价表';

#
# Data for table "st_score"
#

INSERT INTO `st_score` VALUES (3,10,30,9,90.00,'C++'),(4,1,37,6,86.00,'Java Web');

#
# Structure for table "standard"
#

DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title_con` varchar(100) DEFAULT NULL COMMENT '题目内容',
  `type` int(1) DEFAULT NULL COMMENT '题目类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='评价指标表';

#
# Data for table "standard"
#

INSERT INTO `standard` VALUES (2,'责任心强，对学生有爱心，耐心。',0),(3,'即教书又育人，注意对学生的教育引导，以身作则。',0),(4,'遵守教学纪律，不迟到，不早退，上课时不打电话。',0),(5,'为人师表，有工作热情，仪容仪表得体。',0),(6,'语言表达清楚，准确，生动。',0),(7,'条理清晰，逻辑性强。',0),(8,'语速，语调，节奏，音量适中。',0),(9,'用标准的普通话授课。',0),(10,'理论课课板书工整，清晰，布局合理，有美感；实践课经常亲身示范。',0),(11,'备课认真，讲课熟练，按照教学大纲要求授课，对教材钻研透彻。',1),(12,'讲授知识准确系统，重点突出，说理充分。',1),(13,'内容充实，信息量大，举例恰当。',1),(14,'布置，批改作业适当，答疑认真，对同学一视同仁',1),(15,'能结合学生，社会需求的实际组织教学。',1),(16,'用标准的普通话授课。',1),(17,'教法灵活，课堂气氛活跃，能引导，启发学生积极思维。',1),(18,'合理运用现代化教学手段。',1),(19,'课堂教学组织严密，时间安排合理，张弛得当。',1),(20,'敢于管理，师生关系和谐。',1),(21,'合理运用现代化教学手段。（如：利用多媒体教学）',0);

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_no` varchar(20) DEFAULT NULL COMMENT '学号',
  `student_name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `student_pwd` varchar(32) DEFAULT NULL COMMENT '密码',
  `classes_id` int(11) DEFAULT NULL COMMENT '班级id',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `tel` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `time` date DEFAULT NULL COMMENT '添加时间',
  `remark` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='学生表';

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,'169000801','罗建','272ddf63a7167116d0fe20f07a93d9b8',37,'男','13626521230',NULL,NULL),(2,'169000802','袁国进','9eb9d895e16571ca3ffcb48bdda4cfc3',37,'男','13254986355',NULL,NULL),(3,'169000803','冉琳','37df63469d30a8ff0be9e06a5ece9376',37,'男','13996606548',NULL,NULL),(4,'169000804','贺远航','ebe5a3eb9d518adc0e2da53dab1f27bf',37,'男','13698987541',NULL,NULL),(5,'169000804','陈星值','e312820d94b6e887762cad43c62a2b83',37,'男','13695645348',NULL,NULL),(6,'169000805','杨丹','6ee790cd1a742103a87cdd2713255158',37,'女','13695548487',NULL,NULL),(9,'169000101','程思远','3afe31290d9cb15b793c906998e1d9ac',30,'男','17826458960',NULL,NULL),(10,'169000102','覃朗','c71769a7f59f3cf6d915e2d91c58a5e0',30,'男','15689502030',NULL,NULL),(11,'169000103','王五','7b058a692fd942cfdac00db2967c37ae',30,'女','199323213213',NULL,NULL),(12,'169000104','晨晨','24b1b00be5524d75647a0176233cc889',31,'女','18956235020',NULL,NULL),(13,'159000101','欣妈妈','011a375c65c57371aeaff1ed083ebbc3',38,'女','18323751735',NULL,NULL),(14,'159000102','王世龙','4d0815aeae3fd0cfee22483059df8c71',38,'男','15623502130',NULL,NULL),(15,'159000103','李思是','b2d65600f541bb37de176704850b482a',38,'男','18956827841',NULL,NULL),(16,'179000101','左旋','17c4c3aae9664ea9cbf98b408b2f60f8',43,'女','15623521456',NULL,NULL);

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_no` varchar(20) DEFAULT NULL COMMENT '教师工号',
  `teacher_name` varchar(30) DEFAULT NULL COMMENT '姓名',
  `teacher_pwd` varchar(32) DEFAULT NULL COMMENT '密码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `tel` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `dep_id` int(11) DEFAULT NULL COMMENT '院系id',
  `time` date DEFAULT NULL COMMENT '添加时间',
  `remark` text COMMENT '备注',
  `is_manage` int(1) DEFAULT '0' COMMENT '是否开启管理权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='教师表';

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (6,'001','陈绮玲','dc5c7986daef50c1e02ab09b442ee34f','女','1365502310',5,NULL,NULL,0),(7,'002','李兴春','93dd4de5cddba2c733c65f233097f05a','男','13152632059',5,NULL,NULL,0),(8,'003','朱世宇','e88a49bccde359f0cabb40db83ba6080','男','13698554824',5,NULL,NULL,0),(9,'004','陈彬','11364907cf269dd2183b64287156072a','男','187998547665',5,NULL,NULL,0),(10,'005','王贵新','ce08becc73195df12d99d761bfbba68d','男','13272526666',5,NULL,NULL,0),(11,'006','谢东亮','568628e0d993b1973adc718237da6e93','男','13485469962',5,NULL,NULL,0),(12,'007','刘阳','9e94b15ed312fa42232fd87a55db0d39','男','135687846543',5,NULL,NULL,0),(13,'008','王艺婷','a13ee062eff9d7295bfc800a11f33704','女','13272558988',5,NULL,NULL,0),(14,'009','彭娟','dc5e819e186f11ef3f59e6c7d6830c35','女','13266969874',5,NULL,NULL,0),(16,'010','孙双林','ea20a043c08f5168d4409ff4144f32e2','男','18323751735',5,NULL,NULL,0),(17,'011','程书记','84eb13cfed01764d9c401219faa56d53','女','13689561230',6,NULL,NULL,0),(18,'012','何鑫','d2490f048dc3b77a457e3e450ab4eb38','男','19956235789',6,NULL,NULL,0),(19,'013','向红','441954d29ad2a375cef8ea524a2c7e73','女','1343434343',6,NULL,NULL,0),(20,'014','李三','0e51011a4c4891e5c01c12d85c4dcaa7','女','12658975',6,NULL,NULL,0),(21,'015','李家喜','af032fbcb07ffc7bd2569d86ae4ce1f5','男','13689521230',6,NULL,NULL,0),(22,'016','王贺','73f7634ab3f381fb40995f93740b3f8a','男','17789562310',6,NULL,NULL,0),(23,'017','何新华','738cccd4fda172441f216712a488dca6','男','199323213213',7,NULL,NULL,0),(24,'018','李思璇','7658d0d2112eb265d6496cbac9de1e24','女','15623524120',7,NULL,NULL,0),(25,'019','TOM1','9c3ce93643ed68583a32f9056b0dd3b6','女','12652401230',7,NULL,NULL,0),(26,'020','吴倩德','8f03ad02c6cad600d2c00a972a9bcce6','女','17820304569',7,NULL,NULL,0),(27,'021','钱和旭','f803dfeb3583d5099a58a7478f28bd75','男','15689231250',7,NULL,NULL,0),(28,'022','李思维','7f5144f962efde75e0f7661e032166db','女','16923567891',7,NULL,NULL,0);

#
# Structure for table "teacher_course"
#

DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师id',
  `classes_id` int(11) DEFAULT NULL COMMENT '班级id',
  `course_id` int(11) DEFAULT NULL COMMENT '课程id',
  `term_id` int(11) DEFAULT NULL COMMENT '学期id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='授课表';

#
# Data for table "teacher_course"
#

INSERT INTO `teacher_course` VALUES (1,6,37,6,3),(2,7,37,7,3),(3,8,37,12,3),(4,9,37,13,3),(5,10,37,14,3),(6,11,37,15,3),(7,12,37,16,3),(8,13,37,17,3),(9,14,37,18,3),(10,16,37,19,3),(20,17,38,20,3),(21,18,38,8,3),(22,19,38,9,3),(23,20,38,21,3),(24,21,38,22,3),(25,22,38,23,3),(26,23,43,10,3),(27,24,43,11,3),(28,25,43,24,3),(29,26,43,26,3),(30,27,43,25,3),(31,28,43,27,3),(33,12,30,6,7),(34,9,30,13,7),(37,6,30,6,7);

#
# Structure for table "term"
#

DROP TABLE IF EXISTS `term`;
CREATE TABLE `term` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `term_name` varchar(50) DEFAULT NULL COMMENT '学期名称',
  `is_open` int(1) DEFAULT NULL COMMENT '是否启用评价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='学期表';

#
# Data for table "term"
#

INSERT INTO `term` VALUES (3,'2019-2020第一学期',1),(4,'2018-2019第二学期',0),(5,'2018-2019第一学期',0),(7,'2019-2020第二学期',0);

#
# Structure for table "tt_score"
#

DROP TABLE IF EXISTS `tt_score`;
CREATE TABLE `tt_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher1_id` int(11) DEFAULT NULL COMMENT '评价教师id',
  `dep_id` int(11) DEFAULT NULL COMMENT '院系id',
  `teacher2_id` int(11) DEFAULT NULL COMMENT '被评教师id',
  `tt_score` float(5,2) DEFAULT NULL COMMENT '教师评分',
  `course_name` varchar(30) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "tt_score"
#

INSERT INTO `tt_score` VALUES (6,6,5,9,72.00,'C++'),(7,6,5,13,94.00,'HTML5+CSS3'),(8,8,5,11,84.00,'面向对象程序设计'),(9,8,5,10,88.00,'软件工程');
