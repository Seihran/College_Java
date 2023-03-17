
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student
{
    private String studentName = "";
    
    private float studentGrade = 0.0F;
    
    public Student(String studentName, float studentGrade)
    {
        this.studentName = studentName;
        this.studentGrade = studentGrade;
    }
    
    public void setStudentName(String name)
    {
        studentName = name;
    }
    
    public void setStudentGrade(float grade)
    {
        studentGrade = grade;
    }
    
    public String getStudentName()
    {
        return studentName;
    }
    
    public float getStudentGrade()
    {
        return studentGrade;
    }
}
