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

    public Student(){

    }
    public void displayGrades(){
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Grades: "+ grades[i] + "Course: " + courses[i]);
        }
    }

    // Should only be computed if all courses have a corresponding grade
    public int getAveGrade() {
        return (int) Math.round(Arrays.stream(grades).average().orElse(0));
    }
}
