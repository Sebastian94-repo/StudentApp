delete from student;
delete from course;
delete from student_course;

insert into student (id, first_Name, last_Name, jmbag, date_Of_Birth, number_Of_ECTS)
values (1, 'Peter', 'jpa', '1231231232', '1990-06-06', 133);

insert into student (id, first_Name, last_Name, jmbag, date_Of_Birth, number_Of_ECTS)
values (2, 'Karen', 'see', '1231231233', '1990-06-05', 133);

insert into student (id, first_Name, last_Name, jmbag, date_Of_Birth, number_Of_ECTS)
values (3, 'angelica', 'Heber', '1231231234', '1990-06-05', 133);

insert into course (id, name, ectsPoints)
values(1, 'Webapplications', 6);

insert into course (id, name, ectsPoints)
values(2, 'Java introduction', 6);


insert into student_course (id, studentID, courseID)
values(1, 1, 1);
insert into student_course (id, studentID, courseID)
values(2, 2, 1);
insert into student_course (id, studentID, courseID)
values(3, 2, 2);


