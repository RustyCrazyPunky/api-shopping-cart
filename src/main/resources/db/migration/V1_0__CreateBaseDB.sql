CREATE TABLE IF NOT EXISTS shopping_cart_user
(
    id       BIGINT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) not null
);

CREATE TABLE IF NOT EXISTS shopping_cart
(
    id      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES shopping_cart_user (id)
);

CREATE TABLE IF NOT EXISTS shopping_cart_item
(
    id               BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    shopping_cart_id BIGINT NOT NULL,
    product_id       VARCHAR(250) NOT NULL,
    quantity         INT NOT NULL,
    FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart (id)
);