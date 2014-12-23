-- ##################################################
-- CREATE DATABASE
-- ##################################################
create schema bookstore;

-- ##################################################
-- CREATE TABLES
-- ##################################################
create table registered_user
(
  id int not null generated always as identity constraint pk_registered_user primary key,
  email_address varchar(255),
  password varchar(255),
  salt varchar(4),
  first_name varchar(255),
  last_name varchar(255),
  street varchar(255),
  house_number varchar(5),
  zip_code varchar(5),
  city varchar(255)
);
create table user_group
(
  id int not null generated always as identity constraint pk_user_group primary key,
  group_name varchar(255)
);
create table registered_user_group_mapping
(
  id int not null generated always as identity constraint pk_registered_user_group_mapping primary key,
  fk_registered_user_id int constraint fk_registered_user_group_mapping_to_registered_user references registered_user on delete cascade on update restrict,
  fk_user_group_id int constraint fk_registered_user_group_mapping_to_user_group references user_group on delete cascade on update restrict
);
create table payment_transfer
(
  id int not null generated always as identity constraint pk_payment_transfer primary key,
  fk_registered_user_id int constraint fk_payment_transfer_to_registered_user references registered_user on delete cascade on update restrict,
  iban varchar(22),
  bic varchar(11),
  account_holder varchar(255)
);
create table payment_credit_card
(
  id int not null generated always as identity constraint pk_payment_credit_card primary key,
  fk_registered_user_id int constraint fk_payment_credit_card_to_registered_user references registered_user on delete cascade on update restrict,
  credit_card_number varchar(16),
  card_validation_code varchar(4),
  card_holder varchar(255),
  expiration_month int,
  expiration_year int
);
create table publisher
(
  id int not null generated always as identity constraint pk_publisher primary key,
  publisher_name varchar(255)
);
create table author
(
  id int not null generated always as identity constraint pk_author primary key,
  first_name varchar(255),
  last_name varchar(255)
);
create table book
(
  id int not null generated always as identity constraint pk_book primary key,
  isbn_13 varchar(13),
  fk_publisher_id int constraint fk_book_to_publisher references publisher on delete cascade on update restrict,
  fk_author_id int constraint fk_book_to_author references author on delete cascade on update restrict,
  title varchar(255),
  edition int,
  year_of_release int,
  language varchar(255),
  number_of_pages int,
  price double,
  quantity int
);
create table comment
(
  id int not null generated always as identity constraint pk__comment primary key,
  fk_book_id int constraint fk_comment_to_book references book on delete cascade on update restrict,
  fk_registered_user_id int constraint fk_comment_to_registered_user references registered_user on delete cascade on update restrict,
  comment_text varchar(250)
);
create table booking_order
(
  id int not null generated always as identity constraint pk_order primary key,
  fk_registered_user_id int constraint fk_booking_order_to_registered_user references registered_user on delete cascade on update restrict,
  fk_payment_credit_card int constraint fk_booking_order_to_payment_credit_card references payment_credit_card on delete cascade on update restrict,
  fk_payment_transfer int constraint fk_booking_order_to_payment_transfer references payment_transfer on delete cascade on update restrict
);
create table booking_order_detail
(
  id int not null generated always as identity constraint pk_book_order_detail primary key,
  fk_booking_order_id int constraint fk_booking_order_detail_to_booking_order references booking_order on delete cascade on update restrict,
  fk_book_id int constraint fk_booking_order_detail_to_book references book on delete cascade on update restrict,
  quantity int
);

-- ##################################################
-- CREATE VIEWS
-- ##################################################
create view view_user_authentification as
select ru.email_address, ru.password, ug.group_name
from registered_user_group_mapping rugm
left join registered_user ru on rugm.fk_registered_user_id = ru.id
left join user_group ug on rugm.fk_user_group_id = ug.id;

-- ##################################################
-- INSERT (DUMMY) DATA INTO TABLES
-- ##################################################
insert into registered_user (email_address, password, salt, first_name, last_name, street, house_number, zip_code, city) values
('max.mustermann@beispiel.de', 'b6ec4a0c92fc390b8bb30be6efd16b94dd75fe4fd76bd89c8c44daf85295db98', 'Fy73', 'Max', 'Mustermann', 'Abc Str.', '1', '12345', 'Berlin'),
('jan.gabler@beispiel.de', 'c7490aebff95f18e81a97aa84072f8ce714efa893c6f30dee3eac4f560dbe681', 'Bx8N', 'Jan', 'Gabler', 'Def Str.', '2', '12345', 'Berlin'),
('malte.schwering@beispiel.de', 'f178366558ec65e83430a2bdaf5ef0ecad51493d10427234ece1f404e632d223', '9Lr2', 'Malte', 'Schwering', 'Ghi Str.', '3', '12345', 'Berlin');
insert into user_group (group_name) values
('admin'),
('user');
insert into registered_user_group_mapping (fk_registered_user_id, fk_user_group_id) values
(1, 2),
(2, 1),
(3, 1);
insert into payment_transfer (fk_registered_user_id, iban, bic, account_holder) values
(1, 'DE11111111111111111111', '11111111111', 'Max Mustermann'),
(2, 'DE22222222222222222222', '22222222222', 'Jan Gabler'),
(3, 'DE33333333333333333333', '33333333333', 'Malte Schwering');
insert into payment_credit_card (fk_registered_user_id, credit_card_number, card_validation_code, card_holder, expiration_month, expiration_year) values
(1, '1111111111111111', '111', 'Max Mustermann', 1, 2021),
(2, '2222222222222222', '222', 'Jan Gabler', 2, 2022),
(3, '3333333333333333', '333', 'Malte Schwering', 3, 2023);
insert into publisher (publisher_name) values
('Verlag A'),
('Verlag B'),
('Verlag C');
insert into author (first_name, last_name) values
('A.', 'Müller'),
('B.', 'Meier'),
('C.', 'Schulze');
insert into book (isbn_13, fk_publisher_id, fk_author_id, title, edition, year_of_release, language, number_of_pages, price, quantity) values
('1111111111111', 1, 1, 'Buchtitel A', 1, 2001, 'Deutsch', 111, 11.00, 111),
('2222222222222', 2, 2, 'Buchtitel B', 2, 2002, 'Englisch', 222, 22.00, 222),
('3333333333333', 3, 3, 'Buchtitel C', 3, 2003, 'Französisch', 333, 33.00, 333);
insert into comment (fk_book_id, fk_registered_user_id, comment_text) values
(1, 1, 'Kommentar A'),
(2, 2, 'Kommentar B'),
(3, 3, 'Kommentar C');
insert into booking_order (fk_registered_user_id, fk_payment_credit_card, fk_payment_transfer) values
(1, 1, null),
(2, 2, null),
(3, 3, null);
insert into booking_order_detail (fk_booking_order_id, fk_book_id, quantity) values
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- ##################################################
-- DROP VIEWS & TABLES
-- ##################################################
drop view view_user_authentification;
drop table booking_order_detail;
drop table booking_order;
drop table comment;
drop table book;
drop table author;
drop table publisher;
drop table payment_credit_card;
drop table payment_transfer;
drop table registered_user_group_mapping;
drop table user_group;
drop table registered_user;