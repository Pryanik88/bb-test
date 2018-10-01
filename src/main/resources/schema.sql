create table category
(
   id integer not null,
   name varchar(255) not null
);
create table product
(
   id integer not null,
   name varchar(255) not null,
   category integer not null
);