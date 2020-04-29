CREATE TABLE IF NOT EXISTS `painters` (
  `id`          int(11) unsigned    NOT NULL AUTO_INCREMENT,
  `first_name`  varchar(50)         DEFAULT NULL,
  `last_name`   varchar(50)         DEFAULT NULL,
  PRIMARY KEY   (`id`)
)
ENGINE=InnoDB CHARSET=utf8mb4;
