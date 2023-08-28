drop table if exists shopping_cart_item;
drop table if exists shopping_cart_user;
drop table if exists shopping_cart;

delete
from flyway_schema_history
where script like concat('V1_0__', '%');