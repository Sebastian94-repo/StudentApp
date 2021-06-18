create table if not exists student (

    id identity,

    first_Name varchar(100) not null,
    last_Name varchar(100) not null,
    jmbag varchar(10) not null unique,
    date_Of_Birth date not null,
    number_Of_ECTS number not null
    );

create table if not exists course (

    id identity,
    name varchar (100) not null,
    ectsPoints number not null
    );

create table if not exists student_course(

    id identity,
    studentId bigint,
    courseId bigint,
    constraint fk_student foreign key (studentId) references  student(id),
    constraint fk_course foreign key (courseId) references course(Id)

);