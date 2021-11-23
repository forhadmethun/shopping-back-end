create table users
(
    id bigint auto_increment
        primary key,
    email varchar(50) null,
    password varchar(120) null,
    username varchar(20) null,
    constraint UK6dotkott2kjsp8vw4d0m25fb7
        unique (email),
    constraint UKr43af9ap4edm43mmtq01oddj6
        unique (username)
);

create table roles
(
    id int auto_increment
        primary key,
    name varchar(20) null
);

create table user_roles
(
    user_id bigint not null,
    role_id int not null,
    primary key (user_id, role_id),
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id)
);

create table product
(
    id bigint auto_increment
        primary key,
    color varchar(20) null,
    description varchar(255) null,
    name varchar(20) null,
    number_of_available_items int null,
    price decimal(19,2) null,
    `rank` int null
);

create table user_product_cart
(
    id bigint auto_increment
        primary key,
    number_of_items int null,
    product_id bigint null,
    user_id bigint null
);

create table refreshtoken
(
    id bigint not null
        primary key,
    expiry_date datetime not null,
    token varchar(255) not null,
    user_id bigint null,
    constraint UK_or156wbneyk8noo4jstv55ii3
        unique (token),
    constraint FKa652xrdji49m4isx38pp4p80p
        foreign key (user_id) references users (id)
);

