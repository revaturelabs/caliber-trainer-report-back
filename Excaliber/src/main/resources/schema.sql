
--drop table if exists category;
--drop table if exists assessment;
--drop table if exists week;
--drop table if exists week_category;
--drop table if exists week_assessment;
--drop table if exists batch;
--drop table if exists batch_week;
--drop table if exists trainer;
--drop table if exists trainer_batch;


drop table if exists category CASCADE;
drop table if exists assessment CASCADE;
drop table if exists week CASCADE;
drop table if exists week_category CASCADE;
drop table if exists week_assessment CASCADE;
drop table if exists batch CASCADE;
drop table if exists batch_week CASCADE;
drop table if exists trainer CASCADE;
drop table if exists trainer_batch CASCADE;



create table category (
    id serial primary key,
    name varchar not null
);

<<<<<<< HEAD
create table assessment(
    id serial primary key,
 	scoreWeight integer not null,
	type0 varchar not null,
	average float not null,
	category_id integer,
	 foreign key (category_id) references category (id)
=======
create table assessment
(
    id           serial primary key,
    score_weight integer not null,
    type0        varchar not null,
    average      float   not null,
    category_id  integer,
    foreign key (category_id) references category (id)
>>>>>>> 2de89fccc628a3a17e4ff54b0ae9324514d71a6b
);

create table week
(
<<<<<<< HEAD
    id serial primary key,
    weekNumber varchar not null,
    batchId varchar not null,
    technicalStatus varchar not null
=======
    id               serial primary key,
    week_number      varchar not null,
    batch_id         varchar not null,
    technical_status varchar not null
>>>>>>> 2de89fccc628a3a17e4ff54b0ae9324514d71a6b
);

create table week_category
(
    week_id integer not null,
    category_id integer not null,
    foreign key (week_id) references week (id),
    foreign key (category_id) references category (id)
);

create table week_assessment
(
    week_id integer not null,
    assessment_id integer not null,
    foreign key (week_id) references week (id),
    foreign key (assessment_id) references assessment (id)
);

create table batch
(
    id         serial primary key,
    batch_id   varchar not null,
    batch_name varchar not null,
    start_date date,
    end_date   date,
    skill      varchar not null,
    location   varchar not null,
    trainer_id integer not null
);

create table batch_week
(
    batch_id integer not null,
    week_id  integer not null,
    foreign key (batch_id) references batch (id),
    foreign key (week_id) references week (id)
);

create table trainer
(
    id  serial primary key,
    firstName varchar not null,
    lastName varchar not null,
    email varchar not null,
    employeeId varchar
);

create table trainer_batch (
	trainer_id integer not null,
	batch_id integer not null,
	foreign key (trainer_id) references trainer (id),
	foreign key (batch_id) references batch (id)
);

