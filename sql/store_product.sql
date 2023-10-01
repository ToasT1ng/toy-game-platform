CREATE TABLE `store_product` (
    `id` int NOT NULL AUTO_INCREMENT,
    `category` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `gold_type` varchar(100) NOT NULL,
    `price` int NOT NULL,
    `delete_flag` tinyint(1) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;