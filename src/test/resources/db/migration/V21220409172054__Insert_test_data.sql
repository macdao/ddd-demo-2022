INSERT INTO product (id, name, price_in_fen)
VALUES ('product-id-1', 'product-name-1', 10000);
INSERT INTO `order`
(id, user_id, product_id, product_price_in_fen, amount, order_price, contact_name, contact_phone, address)
VALUES ('order-id-1', 'user-id-1', 'product-id-1', 10000, 2, 20000, 'Josh', '13888888888', 'Shanghai');