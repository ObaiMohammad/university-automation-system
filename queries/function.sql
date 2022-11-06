Create or replace function get_student_grad(st_id int, c_id int)
    returns int
    language plpgsql
as
$$
Declare
    grd integer;
Begin

    select grade
    into grd
    from exam_student
             join exams on exam_student.exam_id = exams.id
    where course_id = c_id
      and student_id = st_id;
    return grd;
End;
$$;

drop function get_student_grad(st_id int, c_id int);

select *
from get_student_grad(8, 5);

----------------------------------------------------

create or replace function get_student_by_course(_course_id int)
    returns jsonb
    language plpgsql
as
$$
declare
    res jsonb;
begin
    select jsonb_agg(to_jsonb(sd))
    into res
    from (select sd
          from students sd
                   join course_student cs on sd.id = cs.student_id
          where course_id = _course_id) std;
    return res;
end;
$$;

create or replace function get_student_by_course_soft(_course_id int)
    returns jsonb
    language plpgsql
as
$$
declare
    res jsonb;
    _id int;
begin
    select id into _id from courses where id = _course_id;
    if _id is null then
        return null;
    else
        select coalesce(jsonb_agg(to_jsonb(sd)), jsonb_build_array())
        into res
        from (select sd
              from students sd
                       join course_student cs on sd.id = cs.student_id
              where course_id = _course_id) std;
        return res;
    end if;
end;
$$;


select *
from get_student_by_course_soft(8);

------------------------------

create or replace function get_course_by_student (_student_id int)
    returns jsonb
    language plpgsql
as $$
declare
    _id int;
    cs jsonb;

begin
    select coalesce( jsonb_agg(cst),jsonb_build_array())
    into cs
    from (select c.id,c.title,c.credits
          from courses c
                   join course_student  on c.id = course_student.course_id
          where student_id = _student_id) cst;
    return cs;
end ;
$$;

select * from get_course_by_student(2);

------------------------------------

create or replace procedure set_grade (_exam_id int,_student_id int, _grade int)
    language plpgsql
as
$$
BEGIN
    update exam_student
    set grade = _grade
    where exam_id = _exam_id and student_id = _student_id;
end ;
$$;

select cs.student_id,course_id,grade,exam_id from students join exam_student es on students.id = es.student_id
join course_student cs on students.id = cs.student_id
join courses c on c.id = cs.course_id
where cs.student_id = 2 and course_id = 1
order by exam_id;

update exam_student
set grade = 69
where student_id = 2 and exam_id = 4 ;

call set_grade(5,2,95);

