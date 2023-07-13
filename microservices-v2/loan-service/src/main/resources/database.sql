CREATE TABLE `loan` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `customer_id` bigint NOT NULL,
                         `start_date` date NOT NULL,
                         `loan_type` varchar(100) NOT NULL,
                         `total_loan` int NOT NULL,
                         `amount_paid` int NOT NULL,
                         `outstanding_amount` int NOT NULL,
                         `created_date` date DEFAULT NULL,
                         PRIMARY KEY (`id`)
);

INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_date`)
VALUES ( 1, DATE_SUB(CURDATE(), INTERVAL 250 DAY), 'HOME', 200000, 50000, 150000, DATE_SUB(CURDATE(), INTERVAL 250 DAY));

INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_date`)
VALUES ( 1, DATE_SUB(CURDATE(), INTERVAL 376 DAY), 'VEHICLE', 40000, 10000, 30000, DATE_SUB(CURDATE(), INTERVAL 376 DAY));

INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_date`)
VALUES ( 1, DATE_SUB(CURDATE(), INTERVAL 549 DAY), 'HOME', 50000, 10000, 40000, DATE_SUB(CURDATE(), INTERVAL 549 DAY));

INSERT INTO `loan` ( `customer_id`, `start_date`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `created_date`)
VALUES ( 1, DATE_SUB(CURDATE(), INTERVAL 122 DAY), 'PERSONAL', 10000, 3500, 6500, DATE_SUB(CURDATE(), INTERVAL 122 DAY));