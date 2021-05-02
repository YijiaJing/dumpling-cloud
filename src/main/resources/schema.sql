create table if not exists ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists dumpling (
    id identity,
    name varchar(50) not null,
    createdAt timestamp not null
);

create table if not exists dumpling_ingredients (
    dumpling bigint not null,
    ingredient varchar(4) not null
);

alter table dumpling_ingredients add foreign key (dumpling) references dumpling(id);
alter table dumpling_ingredients add foreign key (ingredient) references ingredient(id);

create table if not exists dumpling_order (
    id identity,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(2) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccExpiration varchar(5) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists dumpling_order_dumplings (
    dumplingOrder bigint not null,
    dumpling bigint not null
);

alter table dumpling_order_dumplings add foreign key (dumplingOrder) references dumpling_order(id);
alter table dumpling_order_dumplings add foreign key (dumpling) references dumpling(id);