DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS account;

CREATE TABLE `customer` (
                            `id` bigint AUTO_INCREMENT  PRIMARY KEY,
                            `name` varchar(100) NOT NULL,
                            `email` varchar(100) NOT NULL,
                            `mobile_number` varchar(20) NOT NULL,
                            `created_date` date DEFAULT NULL
);

CREATE TABLE `account` (
                            `customer_id` bigint NOT NULL,
                            `account_number` bigint PRIMARY KEY,
                            `account_type` varchar(100) NOT NULL,
                            `branch_address` varchar(200) NOT NULL,
                            `created_date` date DEFAULT NULL,
                            foreign key (customer_id) references customer(id)
);

INSERT INTO `customer` (`name`,`email`,`mobile_number`,`created_date`)
VALUES ('Easy Bytes','tutor@eazybytes.com','9876548337', CURDATE());

INSERT INTO `account` (`customer_id`, `account_number`, `account_type`, `branch_address`, `created_date`)
VALUES (1, 186576453, 'SAVING', '123 Main Street, New York', CURDATE());
