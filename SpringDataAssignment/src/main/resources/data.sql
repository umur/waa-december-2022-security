-- Data For Category

INSERT  INTO  Category (name) VALUES ('Electronics');
INSERT  INTO  Category (name) VALUES ('Plants');
INSERT  INTO  Category (name) VALUES ('Foods');

--Data for User
INSERT INTO Users(email,firstName,lastName,password) VALUES ('uinan@miu.edu','Abhay','Rawal','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
INSERT INTO Users(email,firstName,lastName,password)  VALUES ('john@miu.edu','Adarsh','Rawal','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');

--Data For Product

INSERT INTO Product(name,price,rating,category_id,user_id) VALUES ('Phones',200,2.5,1,1);
INSERT INTO Product(name,price,rating,category_id,user_id) VALUES ('Laptop',400,5,1,2);

INSERT INTO Product(name,price,rating,category_id,user_id) VALUES ('Cactus',100,3.5,2,1);
INSERT INTO Product(name,price,rating,category_id,user_id) VALUES ('Marigold',600,4.5,2,2);

INSERT INTO Product(name,price,rating,category_id,user_id) VALUES ('Lays',800,1.5,3,1);
INSERT INTO Product(name,price,rating,category_id,user_id) VALUES ('Noodles',1000,2.5,3,2);



-- Data for Roles
INSERT INTO role(role) VALUES ('admin');
INSERT INTO role(role) VALUES ('user');

-- Data for User_Roles

INSERT INTO user_role(user_id,roles_id) VALUES (1,1);
INSERT INTO user_role(user_id,roles_id) VALUES (2,2);


--Data for Address
INSERT INTO Address(street,zip,city,user_id) VALUES ('10NTH','1432','FairField',1);
INSERT INTO Address(street,zip,city,user_id) VALUES ('110STH','9123','Kathmandu',2);





--Data for Review

INSERT INTO Review(comment,user_id,product_id) VALUES ('Good!',1,1);
INSERT INTO Review(comment,user_id,product_id) VALUES ('Wow!',2,2);


