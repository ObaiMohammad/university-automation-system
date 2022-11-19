insert into students(first_name, last_name, email)
values ('Obai', 'Mohammad', 'obai@gmail.com');

insert into students(first_name, last_name, email)
values ('Odai', 'Mohammad', 'Odai@gmail.com');

insert into students(first_name, last_name, email)
values ('Yazan', 'Akel', 'Yazan@gmail.com');

insert into students(first_name, last_name, email)
values ('Bari', 'Mansour', 'Bari@gmail.com');

insert into students(first_name, last_name, email)
values ('Hisham', 'Zarzoir', 'Hisham@gmail.com');

---------------------------

create or replace procedure add_student (_first_name varchar, _last_name varchar, _email varchar)
    language plpgsql
as
$$
BEGIN
    insert into students(first_name, last_name, email)
    values (_first_name, _last_name, _email);
end;
$$;

call add_student('Ahmad', 'zarzour', 'ahmad@hotmail.com');

---------------------------

insert into courses(title, credits)
values ('Foundation of computer science', 12);

insert into courses(title, credits)
values ('Algebra', 9);

insert into courses(title, credits)
values ('Data structures 1', 6);

insert into courses(title, credits)
values ('Data structures 2', 12);

insert into courses(title, credits)
values ('Networks', 6);

insert into courses(title, credits)
values ('Statics', 6);

---------------

create or replace procedure add_course (_title varchar,_credits varchar)
    language plpgsql
as
$$
BEGIN

    insert into courses(title, credits)
    values (_title, _credits);

end;
$$;


---------------

insert into teachers(first_name, last_name, email)
values ('Alexander', 'The first','alex@gmail.com');

insert into teachers(first_name, last_name, email)
values ('John', 'Snow','John@gmail.com');

insert into teachers(first_name, last_name, email)
values ('Jack', 'Black','Jack@gmail.com');

insert into teachers(first_name, last_name, email)
values ('Sara', 'watson','Sara@gmail.com');

insert into teachers(first_name, last_name, email)
values ('Farez', 'Ahmad','Farez@gmail.com');

insert into teachers(first_name, last_name, email)
values ('Yousef', 'Hosine','Yousef@gmail.com');


---------------

create or replace procedure add_teacher (_first_name varchar, _last_name varchar, _email varchar)
    language plpgsql
as
$$
BEGIN
    insert into teachers(first_name, last_name, email)
    values (_first_name, _last_name, _email);
end;
$$;

---------------
select * from students;
select * from courses;
select * from course_student;

delete  from course_student;

insert into course_student(student_id, course_id)
values (2, 1);
insert into course_student(student_id, course_id)
values (2, 2);
insert into course_student(student_id, course_id)
values (2, 3);
insert into course_student(student_id, course_id)
values (2, 4);
insert into course_student(student_id, course_id)
values (2, 5);
insert into course_student(student_id, course_id)
values (2, 6);
insert into course_student(student_id, course_id)
values (5, 1);
insert into course_student(student_id, course_id)
values (5, 2);
insert into course_student(student_id, course_id)
values (5, 5);
insert into course_student(student_id, course_id)
values (5, 4);
insert into course_student(student_id, course_id)
values (6, 2);
insert into course_student(student_id, course_id)
values (6, 3);
insert into course_student(student_id, course_id)
values (6, 4);
insert into course_student(student_id, course_id)
values (6, 5);
insert into course_student(student_id, course_id)
values (7, 1);
insert into course_student(student_id, course_id)
values (7, 6);
insert into course_student(student_id, course_id)
values (7, 5);
insert into course_student(student_id, course_id)
values (7, 3);
insert into course_student(student_id, course_id)
values (8, 1);
insert into course_student(student_id, course_id)
values (8, 2);
insert into course_student(student_id, course_id)
values (8, 4);
insert into course_student(student_id, course_id)
values (8, 3);


---------------

create or replace procedure add_course_student (_student_id  int,_course_id int)
    language plpgsql
as
$$
BEGIN
    insert into course_student(student_id, course_id)
    values (_student_id, _course_id);

end;
$$;


---------------



select * from teachers;
select * from courses;
delete from course_teacher;

insert into course_teacher(teacher_id, course_id)
values (1, 1);
insert into course_teacher(teacher_id, course_id)
values (3, 2);
insert into course_teacher(teacher_id, course_id)
values (4, 3);
insert into course_teacher(teacher_id, course_id)
values (5, 4);
insert into course_teacher(teacher_id, course_id)
values (5, 5);
insert into course_teacher(teacher_id, course_id)
values (6, 6);
insert into course_teacher(teacher_id, course_id)
values (7, 1);
insert into course_teacher(teacher_id, course_id)
values (6, 2);
insert into course_teacher(teacher_id, course_id)
values (7, 5);
insert into course_teacher(teacher_id, course_id)
values (7, 6);

----------------

create or replace procedure add_course_teacher (_teacher_id  int,_course_id int)
    language plpgsql
as
$$
BEGIN
    insert into course_teacher(teacher_id, course_id)
    values (_teacher_id, _course_id);

end;
$$;


---------------

insert into halls (name)
values ('1A');
insert into halls (name)
values ('2A');
insert into halls (name)
values ('3A');
insert into halls (name)
values ('4A');
insert into halls (name)
values ('5A');

-----------------------

create or replace procedure add_hall (_name varchar)
    language plpgsql
as
$$
BEGIN
    insert into halls (name)
    values (_name);
end ;
$$;

-----------------------

insert into  exams (course_id, hall_id, scheduled_on)
values (1 , 1 , current_timestamp);
insert into  exams (course_id, hall_id, scheduled_on)
values (2 , 2 , current_timestamp);
insert into  exams (course_id, hall_id, scheduled_on)
values (3 , 3 , current_timestamp);
insert into  exams (course_id, hall_id, scheduled_on)
values (4, 4 , current_timestamp);
insert into  exams (course_id, hall_id, scheduled_on)
values (5, 5, current_timestamp);

-----------------------

create or replace procedure add_exam (_course_id  int, _hall_id int,_scheduled_on timestamp)
    language plpgsql
as
$$
BEGIN
    insert into  exams (course_id, hall_id, scheduled_on)
    values (_course_id,_hall_id,_scheduled_on);
end;
$$;

---------------

delete from exam_student;

insert into exam_student (exam_id, student_id, grade)
values (1 ,2, 70);
insert into exam_student (exam_id, student_id, grade)
values (2 ,2, 75);
insert into exam_student (exam_id, student_id, grade)
values (3 ,2, 50);
insert into exam_student (exam_id, student_id, grade)
values (4 ,2, 80);
insert into exam_student (exam_id, student_id, grade)
values (5 ,2, 50);

insert into exam_student (exam_id, student_id, grade)
values (2 ,5, 90);

insert into exam_student (exam_id, student_id, grade)
values (3 ,5, 100);


insert into exam_student (exam_id, student_id, grade)
values (3 ,6, 88);
insert into exam_student (exam_id, student_id, grade)
values (4 ,7, 58);
insert into exam_student (exam_id, student_id, grade)
values (5 ,8, 67);


---------------------------
delete from exam_student where student_id = 5 and exam_id = 3;

---------------------------

create or replace procedure add_exam_student (_exam_id  int, _student_id int)
    language plpgsql
as
$$
BEGIN
    insert into  exam_student (exam_id, student_id, grade)
    values (_exam_id,_student_id);
end;
$$;
