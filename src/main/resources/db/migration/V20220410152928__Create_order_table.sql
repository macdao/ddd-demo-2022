CREATE TABLE `order`
(
    id                   VARCHAR(50),
    user_id              VARCHAR(50),
    product_id           VARCHAR(50),
    product_price_in_fen INT,
    amount               INT,
    order_price          INT,
    contact_name         VARCHAR(50),
    contact_phone        VARCHAR(50),
    address              VARCHAR(500)

);
