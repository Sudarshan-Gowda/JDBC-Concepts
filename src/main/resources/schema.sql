
drop table if exists Users;

create table Users(
 USER_ID int(5) not null,
 USER_NAME varchar(100) not null,
 USER_EMAIL varchar(100) not null,
 USER_ADDRESS varchar(200) not null,
 PRIMARY KEY (`USER_ID`)
);