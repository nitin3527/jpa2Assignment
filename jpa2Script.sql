show databases;
use employee;
show tables;
create database jpa2;
use jpa2;
use employee;
select * from employee;
show databases;
/*===================== Employee table ==========================*/
show tables;
create table employee(
empId int PRIMARY KEY auto_increment,
empFirstName varchar(25),
empFirstName varchar(25),
empSalary decimal,
empAge int
);


/*================ tables for Single Table strategy.. =====================*/
create table payment(
id int PRIMARY KEY,
pmode varchar(2),
amount decimal,
cardnumber varchar(25),
checknumber varchar(25)
);

create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
);

create table bankcheck(
id int PRIMARY KEY,
amount decimal(8,3),
checknumber varchar(20)
)
drop table payment;
select * from payment;
/*================ tables for Table Per Class strategy. =====================*/
create table payment(
id int PRIMARY KEY,
pmode varchar(2),
amount decimal,
cardnumber varchar(25),
checknumber varchar(25)
);

create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
);

create table bankcheck(
id int PRIMARY KEY,
amount decimal(8,3),
checknumber varchar(20)
)

/*================ tables for Joined strategy.. =====================*/
drop table card;
drop table bankcheck;
drop table payment;

create table payment(
id int PRIMARY KEY,
amount decimal(8,3)
);

create table card(
id int ,
cardnumber varchar(20),
 FOREIGN KEY (id)
REFERENCES payment(id)
);

create table bankcheck(
id int ,
checknumber varchar(20),
FOREIGN KEY (id)
REFERENCES payment(id)
)



/* ========================================= Mapping =========================*/

create table employeemapping(
id int,
firstname varchar(20),
lastname varchar(20),
age int,
basicsalary double,
bonussalary double,
taxamount double,
specialallowancesalary double
)


