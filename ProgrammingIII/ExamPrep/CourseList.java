import java.util.*;

public class CourseList {

	public static void main(String[] args)
	{
		ArrayList<Student> students = new ArrayList<Student>();
		
		Student s1 = new Student("John", "Smith");
		students.add(s1);
		Student s2 = new Student("George", "Smith");
		students.add(s2);
		Student s3 = new Student("Emily", "Trenton");
		students.add(s3);
		Student s4 = new Student("Carl", "Brett");
		students.add(s4);
		
		Collections.sort(students);
		System.out.println(students);
		
		Comparator<Student> compareId = new Comparator<Student>()
		{
			@Override
			public int compare(Student p, Student r)
			{
				return Long.compare(p.getID(), r.getID());
			}
		};
		
		Collections.sort(students, compareId);
		System.out.println(students);
	}
}
