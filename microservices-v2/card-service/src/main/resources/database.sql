CREATE TABLE `card` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `card_number` varchar(100) NOT NULL,
                         `customer_id` bigint NOT NULL,
                         `card_type` varchar(100) NOT NULL,
                         `total_limit` int NOT NULL,
                         `amount_used` int NOT NULL,
                         `available_amount` int NOT NULL,
                         `created_date` date DEFAULT NULL,
                         PRIMARY KEY (`id`)
);


INSERT INTO `card` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_date`)
VALUES ('4565XXXX4656', 1, 'CREDIT', 10000, 500, 9500, CURDATE());

INSERT INTO `card` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_date`)
VALUES ('3455XXXX8673', 1, 'CREDIT', 7500, 600, 6900, CURDATE());

INSERT INTO `card` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_date`)
VALUES ('2359XXXX9346', 1, 'CREDIT', 20000, 4000, 16000, CURDATE());