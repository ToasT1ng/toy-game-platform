CREATE TABLE `account` (
    `id` int NOT NULL AUTO_INCREMENT,
    `username` varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `grade` varchar(100) NOT NULL,
    `diamond` int NOT NULL,
    `ruby` int NOT NULL,
    `last_login` datetime NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;