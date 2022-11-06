
create or replace procedure set_teacher_email (_id int,_email varchar)
    language plpgsql
as $$
begin
    update teachers
    set email= _email
    where id = _id;
end;
$$;

--------------------------

create or replace procedure set_student_email (_id int,_email varchar)
    language plpgsql
as $$
begin
    update students
    set email= _email
    where id = _id;
end;
$$;

--------------------------

create or replace procedure set_grade (_student_id int, _exam_id int, _grade int )
    language plpgsql
as $$
begin
    update exam_student
    set grade = _grade
    where exam_id = _exam_id and student_id = _student_id;
end;
$$;

--------------------------

create or replace procedure set_student_email (_id int,_credit int)
    language plpgsql
as $$
begin

    update courses
    set credits = _credit
    where id = _id;
end;
$$;

--------------------------







