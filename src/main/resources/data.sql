INSERT INTO Address (id, city, street, zip)
VALUES(1001, 'Fairfield', '1000 N 4th St', 52557);
INSERT INTO address (id, city, street, zip)
VALUES(1002, 'Ottumwa', '105 E. Third St', 52501);
INSERT INTO address (id, city, street, zip)
VALUES(1003, 'Mt.Pleasent', '307 East Monroe St', 52641);
INSERT INTO address (id, city, street, zip)
VALUES(1004, 'Burlington', '400 North St', 52601);

INSERT INTO category(id, name) VALUES(2001, 'Electronics');
INSERT INTO category(id, name) VALUES(2002, 'Clothing');
INSERT INTO category(id, name) VALUES(2003, 'Furniture');
INSERT INTO category(id, name) VALUES(2004, 'Food');

INSERT INTO product(id, name, price, rating, category_id)
VALUES(3001, 'Laptop', 600, 4, 2001);
INSERT INTO Product(id, name, price, rating, category_id)
VALUES(3002, 'Mobile', 700, 4, 2001);
INSERT INTO Product(id, name, price, rating, category_id)
VALUES(3003, 'Ipad', 600, 4, 2001);
INSERT INTO Product(id, name, price, rating, category_id)
VALUES(3004, 'Hoodie', 60, 3, 2002);
INSERT INTO Product(id, name, price, rating, category_id)
VALUES(3005, 'Chair', 120, 4, 2003);

INSERT INTO users(id, email, first_name, last_name, password, address_id)
VALUES(4001, 'ram@g.com', 'Ram', 'Gurung', 'gurung', 1001);
INSERT INTO users(id, email, first_name, last_name, password, address_id)
VALUES(4002, 'shyam@g.com', 'Shyam', 'Gurung', 'gurung', 1002);
INSERT INTO users(id, email, first_name, last_name, password, address_id)
VALUES(4003, 'hari@g.com', 'Hari', 'Gurung', 'gurung', 1003);
INSERT INTO users(id, email, first_name, last_name, password, address_id)
VALUES(4004, 'gita@g.com', 'Gita', 'Gurung', 'gurung', 1004);

INSERT INTO review(id, comment, product_id, user_id)
VALUES(5001, 'Very Good', 3005, 4001);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5002, 'Very Good', 3005, 4002);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5007, 'Very Good', 3005, 4003);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5003, 'Average', 3001, 4001);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5004, 'Average', 3001, 4002);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5005, 'Bad', 3003, 4003);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5006, 'Very Bad', 3003, 4004);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5008, 'Working good', 3002, 4003);
INSERT INTO review(id, comment, product_id, user_id)
VALUES(5009, 'Bad', 3002, 4004);