CREATE TABLE students
(
    id         serial PRIMARY KEY,
    first_name VARCHAR(20)         NOT NULL,
    last_name  VARCHAR(20)         NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_on TIMESTAMP           NOT NULL
);

--------------------------------------------------------

CREATE TABLE teachers
(
    id         serial PRIMARY KEY,
    first_name VARCHAR(20)         NOT NULL,
    last_name  VARCHAR(20)         NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_on TIMESTAMP           NOT NULL
);

--------------------------------------------------------

CREATE TABLE courses
(
    id         serial PRIMARY KEY,
    title      VARCHAR(20) NOT NULL,
    credits    int         NOT NULL,
    created_on TIMESTAMP   NOT NULL
);

--------------------------------------------------------

CREATE TABLE course_student
(
    student_id INT,
    course_id  INT,
    CONSTRAINT fk_student
        FOREIGN KEY (student_id)
            REFERENCES students (id),
    -- on delete cascade
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES courses (id)
    -- on delete cascade
    -- constraint fk_unique unique (student_id,course_id);
);

-- make the both columns unique so the same student can't enroll in the same course twice
alter table course_student add constraint fk_unique unique (student_id,course_id);

-- add cascade in case of deleting a course or a student
alter table course_student drop constraint fk_course;
alter table course_student drop constraint fk_student;

alter table course_student add constraint fk_course foreign key (course_id)
    references courses (id) on DELETE cascade ;

alter table course_student add constraint fk_student foreign key (student_id)
    references students (id) on DELETE cascade ;


--------------------------------------------------------

CREATE TABLE course_teacher
(
    teacher_id INT,
    course_id  INT,
    CONSTRAINT fk_student --fk_teacher
        FOREIGN KEY (teacher_id)
            REFERENCES teachers (id),
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES courses (id)
);
-------
ALTER table course_teacher rename constraint fk_student to fk_teacher;
ALTER table course_teacher add constraint c_unique  unique (teacher_id,course_id);


-- add cascade in case of deleting a course or a teacher
alter table course_teacher drop constraint fk_teacher;
alter table course_teacher drop constraint fk_course;

alter table course_teacher add constraint fk_course foreign key (course_id)
    references courses (id) on DELETE cascade ;

alter table course_teacher add constraint fk_teacher foreign key (teacher_id)
    references teachers (id) on DELETE cascade ;

-------
create table student_test as(
    SELECT * FROM students
);
------
select * from student_test;
DELETE from student_test;
DELETE from student_test where first_name = 'Obai';
drop TABLE student_test;
--------

create table exams
(
    course_id  INT,
    student_id  INT,
    grade INT,

    CONSTRAINT fk_student
        FOREIGN KEY (student_id)
            REFERENCES students (id),
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES courses (id)
);
-------------
drop table exams;


-------------

create table exams
(
    id serial primary key,
    course_id INT,
    hall_id INT,
    scheduled_on timestamp,
    constraint fk_course
        foreign key (course_id)
            references courses (id),
    constraint fk_hall
        foreign key (hall_id)
            references halls (id)
);
------------------------


-- add cascade in case of deleting a course or a teacher
alter table exams drop constraint fk_hall;
alter table exams drop constraint fk_course;

alter table exams add constraint fk_course foreign key (course_id)
    references courses (id) on DELETE cascade ;

alter table exams add constraint fk_hall foreign key (hall_id)
    references halls (id) on DELETE cascade ;


------------------------

create table halls
(
    id serial primary key ,
    name varchar
);

------------------------


create table exam_student
(
    exam_id int,
    student_id int,
    grade int,

    constraint fk_exam
        foreign key (exam_id)
            references exams (id),
    constraint fk_student
        foreign key (student_id)
            references students (id)

);
------------------------


-- add cascade in case of deleting a course or a teacher
alter table exam_student drop constraint fk_exam;
alter table exam_student drop constraint fk_student;

alter table exam_student add constraint fk_exam foreign key (exam_id)
    references exams (id) on DELETE cascade ;

alter table exam_student add constraint fk_hall foreign key (student_id)
    references students (id) on DELETE cascade ;


------------------------