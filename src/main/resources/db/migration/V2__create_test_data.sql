INSERT INTO roles(name)
VALUES ('ROLE_USER');
INSERT INTO roles(name)
VALUES ('ROLE_ADMIN');

INSERT INTO testdb.users (id, email, password, username)
VALUES (1, 'forhad@gmail.com', '$2a$10$b4a3deWZFEU.sJnJlfZTa.pf0cMxOJOaTghJmmVpxRImkztsZUJzi',
        'forhad'); -- password: forhad
INSERT INTO testdb.users (id, email, password, username)
VALUES (2, 'admin@gmail.com', '$2a$10$b4a3deWZFEU.sJnJlfZTa.pf0cMxOJOaTghJmmVpxRImkztsZUJzi','admin'); -- password: forhad;

INSERT INTO testdb.user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO testdb.user_roles (user_id, role_id)
VALUES (2, 2);

INSERT INTO testdb.product (id, color, description, name, number_of_available_items, price, rank)
 VALUES (1, 'red', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam', 'Apple iPhone 11', 10, 699.00, 22);
INSERT INTO testdb.product (id, color, description, name, number_of_available_items, price, rank)
VALUES (2, 'silver', 'macbook another beautiful laptop,,,foo...baar...', 'MacBook m1 air', 15, 1199.00, 4);