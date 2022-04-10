CREATE TABLE `order`
(
    id                   VARCHAR(50),
    product_id           VARCHAR(50),
    product_price_in_fen INT,
    amount               INT,
    order_price          INT,
    contact_name         VARCHAR(50),
    contact_phone        VARCHAR(50),
    address              VARCHAR(500)

);
INSERT INTO `order` (id, product_id, product_price_in_fen, amount, order_price, contact_name, contact_phone, address)
VALUES ('order-id-1', 'product-id-1', 10000, 2, 20000, 'Josh', '13888888888', 'Shanghai');