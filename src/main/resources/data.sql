insert into users (id,username,email,password) values (1, 'admin', 'admin@localhost','$2a$10$tUeovXn3X93Utm55plgry.YzpWzaWooIdgb3wXssgu6x.5gfJFUzK');--123
insert into users (id,username,email,password) values (2,'user','user@localhost','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');--123


insert into roles (id,name) values (1,'ADMIN');
insert into roles (id,name) values (2,'USER');


insert into users_roles (user_id,roles_id) values (1,1);
insert into users_roles (user_id,roles_id) values (1,2);
insert into users_roles (user_id,roles_id) values (2,2);

insert into products (id,name,price,user_id) values (1,'product1',100,1);
insert into products (id,name,price,user_id) values (2,'product2',1010,2);