CREATE TABLE `charge_order` (
    `id` int NOT NULL AUTO_INCREMENT,
    `user_id` varchar(255) DEFAULT NULL,
    `date` datetime NOT NULL,
    `price` int NOT NULL,
    `diamond` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
