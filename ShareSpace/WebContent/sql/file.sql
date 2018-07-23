CREATE TABLE `file` (
  `fileid` char(36) NOT NULL,
  `filename` char(20) NOT NULL DEFAULT '' COMMENT '文件名称',
  `filepath` char(255) NOT NULL DEFAULT '' COMMENT '文件路径',
  PRIMARY KEY (`fileid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;