-- Data For Category

INSERT  INTO  Category (name) VALUES ('Phone');
INSERT  INTO  Category (name) VALUES ('Laptop');
INSERT  INTO  Category (name) VALUES ('Tablet');

--Data For Product

INSERT INTO Product(name,price,rating,category_id) VALUES ('Iphone 14',1200,8,1);
INSERT INTO Product(name,price,rating,category_id) VALUES ('Samsung Galaxy',1000,6,1);

INSERT INTO Product(name,price,rating,category_id) VALUES ('Macbook Pro',1500,7,2);
INSERT INTO Product(name,price,rating,category_id) VALUES ('Lenovo IdeaPad',1200,6,2);

INSERT INTO Product(name,price,rating,category_id) VALUES ('Samsung Tablet',1000,6,3);
INSERT INTO Product(name,price,rating,category_id) VALUES ('Apple Tablet',1200,6,3);

--Data for User
INSERT INTO Users(email,password,firstName,lastName) VALUES ('user1@miu.edu','1234','User','One');
INSERT INTO Users(email,password,firstName,lastName) VALUES ('user2@miu.edu','1234','User','Two');

--Data for Address
INSERT INTO Address(street,zip,city,user_id) VALUES ('1000N 4TH','52557','FairField',1);
INSERT INTO Address(street,zip,city,user_id) VALUES ('1001N 4th','52557','Fairfield',2);


--Data for Review

INSERT INTO Review(comment,user_id,product_id) VALUES ('It has amazing camera feature',1,1);
INSERT INTO Review(comment,user_id,product_id) VALUES ('It runs smoothly and has light weight ',2,4);

--Data for Roles
INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'GOLD');


--Data for user roles
INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);