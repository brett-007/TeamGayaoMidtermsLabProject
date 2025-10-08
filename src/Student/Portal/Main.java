package Student.Portal;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    private static DoublyLinkedList<DoublyLinkedList<DoublyLinkedList<Student>>> portal = new DoublyLinkedList<>("portal");

    public static void main(String[] args) {
        /*
        NOTE
            - program will be a 3 level list
            - sublist of schools will be fixed, CRUD will only be allowed in program, course, and student levels
            - only reference class will be node, doubly linked list, and student
            - revise doubly linked node to remove main method. main method should be here

        UNIVERSITY aka portal list (main list)
            - SAMCIS (sublist 1)
                - BSCS (Program 1)
                    - Student 1
                    - Student 2
                    - Student 3
                    - Student 4
                - BSHM (Program 2)
                - BSA (Program 3)
            - SEA (sublist 2)
                - BSECE
                - BSCE
                - BSARCH
            - SOHNABS (sublist 3)
                - BSN
                - BSP
                - BSMLS
            - STELLA (sublist 4)
                - BSPsych
                - BSED
                - BSComm

            FEATURES FOR THE PROGRAM
            [1] View school details
                - print prompt and ask which school and program to be printed
                - display all students
                - select student [optional for user]
            [2] Add school, program, and student
                - enter name
                - check if duplicate
                - create new school list
            [3] Update school, program, and student
                - enter name
                - check if duplicate
                - create new program list
            [4] Delete school, program, and student
                - select if school, program, or student to delete
            [5] Search student only




         */

//        SAMPLE ADDITION TO THE PORTAL LIST
//        DoublyLinkedList<Student> program = new DoublyLinkedList<>("program");
//        program.insert(new Student());
//
//        DoublyLinkedList<DoublyLinkedList<Student>> school = new DoublyLinkedList<>("school");
//        school.insert(program);
//
//        portal.insert(school);
    }
}
