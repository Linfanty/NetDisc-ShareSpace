CREATE TABLE `user_file` (
  `userid` int(11) NOT NULL,
  `fileid` char(36) NOT NULL,
  PRIMARY KEY (`userid`,`fileid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;