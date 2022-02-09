--水平分表

CREATE TABLE inventory_0(
    id int,
    items JSON,
    INDEX i1 ( (JSON_VALUE(items, '$.name' RETURNING CHAR(50))) )
);

CREATE TABLE inventory_1(
    id int,
    items JSON,
    INDEX i1 ( (JSON_VALUE(items, '$.price' RETURNING DECIMAL(5,2))) )
);