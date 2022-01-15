create database coffee CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use coffee;

create table users(
	-- id: 1.Admin, 2.Customer
	id int auto_increment primary key,
    full_name varchar(300),
    -- gender: 1.Nam, 2.Nữ, 3. khác
    gender int,
    phone varchar(20),
    date_of_birth date,
    -- status: 1.Hoạt động, 2.Khóa
    status int,
    avatar text null,
    user_name varchar(100),
    password text
);
insert into users(full_name, gender, phone, date_of_birth, status, user_name, password) 
values('Trần Minh Trí',1,'0357021254','2000-07-12',1,'admin','1');

insert into users(full_name, gender, phone, date_of_birth, status, user_name, password) 
values('Nguyễn Văn A',1,'0357021254','2000-07-12',1,'nva','1');

create table categories(
	id int auto_increment primary key,
    category_name varchar(300)
);
insert into categories(category_name) values('Cà phê');
insert into categories(category_name) values('Nước ép');
insert into categories(category_name) values('Trà sữa');

create table drinks(
	id int auto_increment primary key,
    category_id int, FOREIGN KEY (category_id) REFERENCES categories(id),
    drink_name varchar(300),
    description text,
    image text null,
    price float
);

insert into drinks(category_id, drink_name, description, price) 
values(1,'Cà phê đá', 'Cà phê uống bao phê',15000);
insert into drinks(category_id, drink_name, description, price) 
values(1,'Cà phê đá', 'Cà phê sữa đá uống bao đã',20000);

create table tables(
	id int auto_increment primary key,
	table_name varchar(20),
    -- status 1.Trống, 2.Có khách
    status int default 1
);

insert into tables(table_name) values('Bàn 1');
insert into tables(table_name) values('Bàn 2');
insert into tables(table_name) values('Bàn 3');
insert into tables(table_name) values('Bàn 4');

create table orders(
	id int auto_increment primary key,
	table_id int, FOREIGN KEY (table_id) REFERENCES tables(id),
    staff_id int, FOREIGN KEY (staff_id) REFERENCES users(id),
    -- status: 1.Chưa thanh toán, 2.Đã thanh toán
    status int default 1,
    booking_date datetime,
    total float
);

insert into orders(table_id, staff_id, booking_date,total) values(1,1,now(),15000);

create table order_details(
	order_id int, FOREIGN KEY (order_id) REFERENCES orders(id),
	drink_id int, FOREIGN KEY (drink_id) REFERENCES drinks(id),
    number int
);

insert into order_details(order_id, drink_id, number) values(1,1,1);