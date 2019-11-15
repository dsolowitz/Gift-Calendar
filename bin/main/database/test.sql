insert into users (username) values ('george');
insert into users (username) values ('billy');
insert into users (username) values ('pickle');
insert into users (username) values ('tommas');
insert into users (username) values ('bucky');

insert into questionnaires (creator, gender, age, hobbies, motivation, pricing, category, holiday, webPreference, customized) values (
1, 'male', '37', 'fishing', 'money', '20-100', 'Outdoors', 'Birthday', 'Amazon', 'Yes');


create table users (
	id integer auto_increment,
	username varchar(25) unique not null
);

create table questionnaires
(
    id            integer auto_increment,
    creator       integer      not null,
    gender        varchar(20)  not null,
    age           varchar(3)   not null,
    hobbies       varchar(100) not null,
    motivation    varchar(20)  not null,
    pricing       varchar(20)  not null,
    category      varchar(20)  not null,
    holiday       varchar(20)  not null,
    webPreference varchar(20)  not null,
    customized    varchar(10)  not null,
    foreign key (creator) references users (id)

);