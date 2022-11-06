
create or replace procedure delete_student (_student_id int)
    language plpgsql
as
$$
BEGIN
    delete from students
    where id = _student_id;
end ;
$$;


create or replace procedure delete_teacher (_teacher_id int)
    language plpgsql
as
$$
BEGIN

    delete from teachers
    where id = _teacher_id;
end ;
$$;


create or replace procedure delete_exam (_exam_id int)
    language plpgsql
as
$$
BEGIN

    delete from exams
    where id =_exam_id;
end ;
$$;



create or replace procedure delete_course_student(_student_id int,_course_id int)
    language plpgsql
as
$$
BEGIN
    delete from course_student
    where student_id = _student_id  and course_id=_course_id;
end ;
$$;


create or replace procedure delete_exam_student (_student_id int,_exam_id int)
    language plpgsql
as
$$
BEGIN
    delete from exam_student
    where student_id = _student_id and exam_id = _exam_id;
end ;
$$;


call delete_student(6);















