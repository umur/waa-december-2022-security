
INSERT INTO Address (id, city, street, zip,user_id)
VALUES(02, 'Fairfield', '1000 N 4th St', 52557, 01);


INSERT INTO category(id, name) VALUES(02, 'Gilbert');

INSERT INTO product(id, name, price, rating, category_id)
VALUES(01, 'EyeGlasses', 10.9, 4, 01);

INSERT INTO people (id, email, firstname, lastname, password, address_id)
VALUES (1, 'gilbert.mumbere@miu.edu', 'Gilbert', 'Mumbere', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2', 52554); --123

INSERT INTO review(id, comment, user_id)
VALUES(5001, 'Very Good', 6001);

