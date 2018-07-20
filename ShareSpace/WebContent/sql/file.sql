CREATE TABLE `file` (
  `id` char(36) NOT NULL,
  `filename` char(20) NOT NULL DEFAULT '' COMMENT '文件名称',
  `filepath` char(255) NOT NULL DEFAULT '' COMMENT '文件路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;