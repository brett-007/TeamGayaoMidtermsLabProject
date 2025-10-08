package Student.Portal;
import java.util.Arrays;

public class Student {
    private String lastName;
    private String firstName;
    private int studentId;
    private String program;
    private byte yearLevel;
    private int[] grades;
    private String[] courses;
    private String schoolEmail;

    public Student() {}

    public Student(String firstName, String lastName, int studentId, String program, byte yearLevel, String schoolEmail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.program = program;
        this.yearLevel = yearLevel;
        this.schoolEmail = schoolEmail;
    }

    // Getters and Setters (search)
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getProgram() { return program; }
    public void setProgram(String program) { this.program = program; }

    public byte getYearLevel() { return yearLevel; }
    public void setYearLevel(byte yearLevel) { this.yearLevel = yearLevel; }

    public String getSchoolEmail() { return schoolEmail; }
    public void setSchoolEmail(String schoolEmail) { this.schoolEmail = schoolEmail; }



    public void displayGrades() {
        if (grades == null || courses == null || grades.length != courses.length) {
            System.out.println("No complete grade data available.");
            return;
        }
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Course: " + courses[i] + " | Grade: " + grades[i]);
        }
    }
    public int getAveGrade() {
        return (int) Math.round(Arrays.stream(grades).average().orElse(0));
    }

    @Override
    public String toString() {
        return String.format("%s %s | Program: %s | Year: %d | ID: %d | Email: %s",
                firstName, lastName, program, yearLevel, studentId, schoolEmail);
    }
}
