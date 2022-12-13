INSERT INTO users (id, email, firstname, lastname, password)
VALUES (1000, 'uinan@miu.edu', 'umur', 'inan', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123
INSERT INTO users (id, email, firstname, lastname, password)
VALUES (2000, 'john@miu.edu', 'john', 'doe', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); --123

insert into role values (1, 'ADMIN');
insert into role values (2, 'GOLD');

insert into users_roles(user_id, roles_id) values (1000, 1);
insert into users_roles(user_id, roles_id) values (1000, 2);
insert into users_roles(user_id, roles_id) values (2000, 2);

insert into product values(1000, 'Iphone 12', 800, 1000);
insert into product values(2000, 'Google Pixel 6', 500, 1000);
insert into product values(3000, 'Iphone 13', 900, 2000);
insert into product values(4000, 'Galaxy S21', 1000, 2000);