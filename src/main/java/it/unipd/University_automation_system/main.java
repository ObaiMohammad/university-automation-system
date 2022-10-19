package it.unipd.University_automation_system;

public class main {

	public static void main(String[] args) {
		
		Course foundationCS = new Course(001,"Foundation of computer seince",12 );
		Course dataStructures1 = new Course(002,"Data structures and Algorithm",12 );
		Course dataStructures2 = new Course(003,"Data structures and Algorithm",6 );
		Course math = new Course(004,"mathimatic",6 );
		
		Student obai = new Student (001,"Obai","Mohammad","obai@gmail.com");
		Student odai = new Student (002,"Odai","Mohammad","odai@yahoo.com");
		Student iyad = new Student (003,"Iyad","Zeb","Iyad@gmail.com");
		
		Teacher alex = new Teacher (011,"Alexander", "The first","alex@gmail.com");
		Teacher john = new Teacher (012,"John", "Snow","john@gmail.com");
		Teacher jack = new Teacher (013,"Jack", "Black","jack@gmail.com");
		
		CourseStudent fCSobai = new CourseStudent (foundationCS , obai);
		
		System.out.println(obai.toString());
		
		

	}

}
