ALTER TABLE shopping_cart
    drop COLUMN closed;

delete
from flyway_schema_history
where script like concat('V1_1__', '%');