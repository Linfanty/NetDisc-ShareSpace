CREATE TABLE `user_file` (
  `user_id` int(11) NOT NULL,
  `file_id` char(36) NOT NULL,
  PRIMARY KEY (`user_id`,`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;