insert into public.category (id, name,price)values (1,'cat',100);
insert into public.category (id, name,price)values (2,'pig',200);
insert into public.category (id, name,price)values (3,'dog',300);
insert into public.category (id, name,price)values (4,'bird',400);

insert into product (id, name, price, rating, id_category,created_by_user_email) values (1,'cat pot',50,0.02,1,'675601125@qq.com');
insert into product (id, name, price, rating, id_category,created_by_user_email) values (2,'dog pot',100,0.01,3,'675601125@qq.com');
insert into product (id, name, price, rating, id_category,created_by_user_email) values (3,'bird pot',150,0.03,4,'675601125@qq.com');

insert into public.address (id, city, street, zip)
values (1,'fairfield','R13 1000N 4th','52557');
insert into public.address (id, city, street, zip)
values (2,'fairfield','R14 1000N 4th','52557');
insert into public.address (id, city, street, zip)
values (3,'fairfield','R15 1000N 4th','52557');


insert into hw_user (id, email, first_name, last_name, password, address_id)
values (1,'675601125@qq.com','meijuan','long','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',1);
insert into hw_user (id, email, first_name, last_name, password, address_id)
values (2,'88888888@qq.com','hassan','raza','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',2);
insert into hw_user (id, email, first_name, last_name, password, address_id)
values (3,'99999999@qq.com','superman','raza','$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2',3);


insert into review (id, comment, product_id, user_id)
values (1,'the dog pot is good',2,2);
insert into review (id, comment, product_id, user_id)
values (2,'the cat pot is useful',1,1);
insert into review (id, comment, product_id, user_id)
values (3,'the bird pot is bad',3,3);

INSERT INTO role (id, role)
VALUES (1, 'ADMIN');
INSERT INTO role (id, role)
VALUES (2, 'USER');



INSERT INTO hw_user_roles (hw_user_id, roles_id)
VALUES (1, 1);
INSERT INTO hw_user_roles (hw_user_id, roles_id)
VALUES (2, 2);
INSERT INTO hw_user_roles (hw_user_id, roles_id)
VALUES (3, 2);

Insert  into OffensiveWords(id,word) values (1,'fuck');
Insert  into OffensiveWords(id,word) values (2,'sex');
Insert  into OffensiveWords(id,word) values (3,'political');

