select st.id, st.first_name, st.last_name, st.email
from students st
         join course_student cs on st.id = cs.student_id
where course_id = 1;

select c.id, title, credits
from courses c
         join course_student cs on c.id = cs.course_id
where student_id = 2;

-----------------

select t.id, t.first_name, t.last_name, t.email
from teachers t
         join course_teacher cs on t.id = cs.teacher_id
where course_id = 5;

select c.id, title, credits
from courses c
         join course_teacher cs on c.id = cs.course_id
where teacher_id = 1;

-----------------------

select t.id, first_name, last_name, email, c.id, title
from teachers t
         join course_teacher ct on t.id = ct.teacher_id
         join course_student cs on ct.course_id = cs.course_id
         join courses c on c.id = cs.course_id
where student_id = 2;

select row_to_json(rowset1, true)
from (select t.id,
             first_name,
             last_name,
             email,
             (select json_agg(sub) from  (select *
                        from courses
                                 join course_teacher ct2 on courses.id = ct2.course_id
                        where ct2.teacher_id = t.id) sub) as courses
      from teachers t
               join course_teacher ct on t.id = ct.teacher_id
               join course_student cs on ct.course_id = cs.course_id
               join courses c on c.id = cs.course_id
      where student_id = 2
      order by t.id) rowset1;


select row_to_json(rowset1, true)
from (select t.id,
             first_name,
             last_name,
             email,
             json_build_array( c.id,c.title,c.credits) as "courses"
      from teachers t
               join course_teacher ct on t.id = ct.teacher_id
               join course_student cs on ct.course_id = cs.course_id
               join courses c on c.id = cs.course_id
      where student_id = 2
      order by t.id) rowset1;


select json_agg(rowset)
from (select t.id, first_name, last_name, email, c.id, title
      from teachers t
               join course_teacher ct on t.id = ct.teacher_id
               join course_student cs on ct.course_id = cs.course_id
               join courses c on c.id = cs.course_id
      where student_id = 2
      order by t.id) rowset;


---------------------------

select student_id, course_id, title, grade, credits
from exam_student
         join exams e on e.id = exam_student.exam_id
         join courses c on c.id = e.course_id
where student_id = ?;

select grade
from exam_student
         join exams on exam_student.exam_id = exams.id
where course_id = ?
  and student_id = ?;

---------------------------

select * from students where id = 2;


select jsonb_agg(st)
from (select * from students where id = ? )st;

