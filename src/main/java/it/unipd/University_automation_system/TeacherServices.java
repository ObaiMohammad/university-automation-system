package it.unipd.University_automation_system;

public class TeacherServices {


    public  void  addTeacher(String firstName, String lastName, String email) {

        TeacherRepositoryImplementation tr = new TeacherRepositoryImplementation ();
        tr.addTeacher( firstName,  lastName,  email);
    }

    public  Teacher getTeacher(int id) {

        TeacherRepositoryImplementation tr = new TeacherRepositoryImplementation ();
        return tr.getTeacher(id);
    }

    public  void updateEmail(int id ,String email) {

        TeacherRepositoryImplementation tr = new TeacherRepositoryImplementation ();
        tr.updateEmail(id,email);
    }

    public  void deleteTeacher(int id) {

        TeacherRepositoryImplementation tr = new TeacherRepositoryImplementation ();
        tr.deleteTeacher(id);
    }


}
