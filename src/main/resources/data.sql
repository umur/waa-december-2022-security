-- Data For Category

INSERT  INTO  Category (name) VALUES ('Fishing Gear');
INSERT  INTO  Category (name) VALUES ('Boat');
INSERT  INTO  Category (name) VALUES ('Kayak');

--Data For Product

INSERT INTO Product(name,price,rating,category_id) VALUES ('A',200,2.5,1);
INSERT INTO Product(name,price,rating,category_id) VALUES ('B',400,5,1);

INSERT INTO Product(name,price,rating,category_id) VALUES ('C',100,3.5,2);
INSERT INTO Product(name,price,rating,category_id) VALUES ('D',600,4.5,2);

INSERT INTO Product(name,price,rating,category_id) VALUES ('E',800,1.5,3);
INSERT INTO Product(name,price,rating,category_id) VALUES ('F',1000,2.5,3);

--Data for User
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');

INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);
--Data for Address
INSERT INTO Address(street,zip,city,user_id) VALUES ('10NTH','1432','sdf',1);
INSERT INTO Address(street,zip,city,user_id) VALUES ('110STH','9123','sdf',2);





--Data for Review

INSERT INTO Review(comment,user_id,product_id) VALUES ('Good!',1,1);
INSERT INTO Review(comment,user_id,product_id) VALUES ('Wow!',2,2);


