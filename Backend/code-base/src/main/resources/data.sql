-- role

INSERT INTO role (role)
VALUES ('ADMIN');

INSERT INTO role (role)
VALUES ('USER');

-- user

INSERT INTO users (email, firstname, lastname, password)
VALUES ('john@miu.edu', 'John', 'Smith', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --Password=123

INSERT INTO users (email, firstname, lastname, password)
VALUES ('jack@miu.edu', 'Jack', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --Password=123

INSERT INTO users (email, firstname, lastname, password)
VALUES ('jane@miu.edu', 'Jane', 'Smith', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --Password=123

INSERT INTO users (email, firstname, lastname, password)
VALUES ('jerry@miu.edu', 'Jerry', 'Doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --Password=123

-- address

INSERT INTO address (city, street, zip, user_id)
VALUES ('Fairfield', '1000N 4th St', '52557', (SELECT id FROM users WHERE email = 'john@miu.edu'));

INSERT INTO address (city, street, zip, user_id)
VALUES ('Fairfield', '507 W Burlington Ave', '52557', (SELECT id FROM users WHERE email = 'jack@miu.edu'));

INSERT INTO address (city, street, zip, user_id)
VALUES ('Fairfield', '104 W Adams Ave', '52557', (SELECT id FROM users WHERE email = 'jane@miu.edu'));

INSERT INTO address (city, street, zip, user_id)
VALUES ('Fairfield', '117 N Court St', '52557', (SELECT id FROM users WHERE email = 'jerry@miu.edu'));

-- user_roles

INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE email = 'john@miu.edu'), (SELECT id FROM role WHERE role = 'ADMIN'));
INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE email = 'jack@miu.edu'), (SELECT id FROM role WHERE role = 'USER'));
INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE email = 'jane@miu.edu'), (SELECT id FROM role WHERE role = 'USER'));
INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE email = 'jerry@miu.edu'), (SELECT id FROM role WHERE role = 'USER'));

-- category

INSERT INTO category (name)
VALUES ('Sports');

INSERT INTO category (name)
VALUES ('Electronics');

INSERT INTO category (name)
VALUES ('Groceries');

INSERT INTO category (name)
VALUES ('Clothing');

-- product

INSERT INTO product (name, price, rating, category_id, user_id)
VALUES ('Mac Pro 14 inch.', 1849, 9.0, (SELECT id FROM category WHERE name = 'Electronics'), (SELECT id FROM users WHERE email = 'jerry@miu.edu'));

INSERT INTO product (name, price, rating, category_id, user_id)
VALUES ('Blue Medium Polo Shirt', 28, 5.75, (SELECT id FROM category WHERE name = 'Clothing'), (SELECT id FROM users WHERE email = 'jane@miu.edu'));

INSERT INTO product (name, price, rating, category_id, user_id)
VALUES ('Football Shoes Size 42', 80, 6.5, (SELECT id FROM category WHERE name = 'Sports'), (SELECT id FROM users WHERE email = 'jack@miu.edu'));

INSERT INTO product (name, price, rating, category_id, user_id)
VALUES ('Planters Mixed Nuts 500gm', 9, 4.25, (SELECT id FROM category WHERE name = 'Groceries'), (SELECT id FROM users WHERE email = 'jane@miu.edu'));

-- review

INSERT INTO review (comment, user_id, product_id)
VALUES ('Excellent device', (SELECT id FROM users WHERE email = 'jerry@miu.edu'), (SELECT id FROM product WHERE name = 'Mac Pro 14 inch.'));

INSERT INTO review (comment, user_id, product_id)
VALUES ('Good style and fitting', (SELECT id FROM users WHERE email = 'jane@miu.edu'), (SELECT id FROM product WHERE name = 'Blue Medium Polo Shirt'));

INSERT INTO review (comment, user_id, product_id)
VALUES ('Okay and comfortable', (SELECT id FROM users WHERE email = 'jack@miu.edu'), (SELECT id FROM product WHERE name = 'Football Shoes Size 42'));

INSERT INTO review (comment, user_id, product_id)
VALUES ('Average quality and not very delicious', (SELECT id FROM users WHERE email = 'jane@miu.edu'), (SELECT id FROM product WHERE name = 'Planters Mixed Nuts 500gm'));
