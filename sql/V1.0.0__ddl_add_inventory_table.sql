CREATE TABLE inventory(
    id int,
    items JSON,
    INDEX i1 ( (JSON_VALUE(items, '$.name' RETURNING CHAR(50))) ),
    INDEX i2 ( (JSON_VALUE(items, '$.price' RETURNING DECIMAL(5,2))) ),
    INDEX i3 ( (JSON_VALUE(items, '$.quantity' RETURNING UNSIGNED)) )
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;;
