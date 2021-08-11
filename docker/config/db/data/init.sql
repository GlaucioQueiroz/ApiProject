CREATE TABLE `user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`login` VARCHAR(255) NULL DEFAULT NULL,
	`password` VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UK_ew1hvam8uwaknuaellwhqchhb` (`login`)
)
COLLATE='utf8_general_ci'
;

REPLACE INTO `user` (`id`, `login`, `password`) VALUES (1, 'User01', '$2a$12$gCLP.Xlfq4R/phZKxb1qqOcQAMaQzgEAu/G6PoFStosDsGS.XWKMy');