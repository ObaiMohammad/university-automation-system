package it.unipd.University_automation_system;

public class StudentServices {

    public  void  addStudent(String firstName, String lastName, String email) {

        StudentRepositoryImplementation st = new StudentRepositoryImplementation ();
        st.addStudent( firstName,  lastName,  email);
    }

    public  Student getStudent(int id) {

        StudentRepositoryImplementation st = new StudentRepositoryImplementation ();
        return st.getStudent(id);
    }

    public  void updateEmail(int id ,String email) {

        StudentRepositoryImplementation st = new StudentRepositoryImplementation ();
        st.updateEmail(id,email);
    }

    public  void deleteStudent(int id) {

        StudentRepositoryImplementation st = new StudentRepositoryImplementation ();
        st.deleteStudent(id);
    }

}
