--Data for Users

INSERT INTO users ( email, firstname, lastname, password)
VALUES ('prabesh@miu.edu', 'Prabesh', 'KC', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users ( email, firstname, lastname, password)
VALUES ('john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123


-- Data for Roles
INSERT INTO role ( role)
VALUES ('ADMIN');
INSERT INTO role ( role)
VALUES ('GOLD');

-- Data for UserRoles
INSERT INTO users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);

-- Data For Category

INSERT  INTO  Category (name) VALUES ('Car');
INSERT  INTO  Category (name) VALUES ('Motorbike');
INSERT  INTO  Category (name) VALUES ('Rocket');

--Data For Product

INSERT INTO Product(name,price,rating,category_id, id_user) VALUES ('Corolla',25000,9.0,1,1);
INSERT INTO Product(name,price,rating,category_id, id_user) VALUES ('VWPolo',36000,8.5,1,2);

INSERT INTO Product(name,price,rating,category_id, id_user) VALUES ('Harley VRod',26000,9.5,2,1);
INSERT INTO Product(name,price,rating,category_id, id_user) VALUES ('Vespa',5000,8.5,2,2);

INSERT INTO Product(name,price,rating,category_id, id_user) VALUES ('Falcon9',2500000,8.5,3,1);
INSERT INTO Product(name,price,rating,category_id, id_user) VALUES ('Saturn5',1100000000,10,3,2);

--Data for User
-- INSERT INTO Users(email,password,firstName,lastName) VALUES ('prabesh.kc@miu.edu','asdf','Prabesh','KC');
-- INSERT INTO Users(email,password,firstName,lastName) VALUES ('karna.shrestha@miu.edu','asdf','Karna','Shrestha');

--Data for Address
INSERT INTO Address(street,zip,city,user_id) VALUES ('1000NTH','52557','FairField',1);
INSERT INTO Address(street,zip,city,user_id) VALUES ('1001N 4th St','52557','Fairfield',2);


--Data for Review

INSERT INTO Review(comment,user_id,product_id) VALUES ('I have seen better cars!',1,1);
INSERT INTO Review(comment,user_id,product_id) VALUES ('The bike is awesome!',2,2);

