package Student.Portal;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    private static final DoublyLinkedList<DoublyLinkedList<DoublyLinkedList<Student>>> portal = new DoublyLinkedList<>("portal");

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

        /* SAMPLE ADDITION TO THE PORTAL LIST
        DoublyLinkedList<Student> program = new DoublyLinkedList<>("program");
        program.insert(new Student());

        DoublyLinkedList<DoublyLinkedList<Student>> school = new DoublyLinkedList<>("school");
        school.insert(program);

        portal.insert(school);

        */

        do{
            try {
                System.out.println("""
                        --- PORTAL MAIN MENU ---
                        [1] View School information
                        [2] Add new branches
                        [3] Update branches
                        [4] Delete branches
                        [5] Search Student
                        [6] Exit Program
                        """);
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(input.nextLine());

                switch (choice){
                    case 1 -> viewMenu();
                    case 2 -> System.out.println();
                    case 3 -> System.out.println();
                    case 4 -> System.out.println();
                    case 5 -> searchMenu();
                    case 6 -> {
                        System.out.println("Thank you for using the School Management Portal. \nExiting Program...");
                        System.exit(0);
                    }

                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid Choice. Please select a number with a corresponding action");
            }
        } while (true);

    }

    private static void searchMenu(){
        // [5] Search Feature (by name or ID number) - lara
        boolean running = true;
        while (running) {
            System.out.println("\n--- PORTAL SEARCH MENU ---");
            System.out.println("[1] Search Student by Name");
            System.out.println("[2] Search Student by ID Number");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name (First or Last): ");
                    String name = input.nextLine().trim().toLowerCase();
                    searchStudentByName(name);
                    break;
                case 2:
                    System.out.print("Enter Student ID Number: ");
                    int id = input.nextInt();
                    searchStudentById(id);
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting search menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void searchStudentByName(String name) { boolean found = false;
        for (int i = 0; i < portal.getSize(); i++) {DoublyLinkedList<DoublyLinkedList<Student>> school = portal.getElement(i);
            for (int j = 0; j < school.getSize(); j++) { DoublyLinkedList<Student> program = school.getElement(j);
                for (int k = 0; k < program.getSize(); k++) {
                    Student s = program.getElement(k);
                    String fullName = (s.getFirstName() + " " + s.getLastName()).toLowerCase();

                    if (fullName.contains(name)) {
                        System.out.println("\n[FOUND]");
                        System.out.println("Name: " + s.getFirstName() + " " + s.getLastName());
                        System.out.println("Program: " + s.getProgram());
                        System.out.println("Year Level: " + s.getYearLevel());
                        System.out.println("ID Number: " + s.getStudentId());
                        System.out.println("School Email: " + s.getSchoolEmail());
                        found = true; }
                }
            }
        }
        if (!found) {System.out.println("\nNo student found with the name: " + name);}
    }

    private static void searchStudentById(int id) { boolean found = false;
        for (int i = 0; i < portal.getSize(); i++) { DoublyLinkedList<DoublyLinkedList<Student>> school = portal.getElement(i);
            for (int j = 0; j < school.getSize(); j++) { DoublyLinkedList<Student> program = school.getElement(j);
                for (int k = 0; k < program.getSize(); k++) { Student s = program.getElement(k);

                    if (s.getStudentId() == id) {
                        System.out.println("\n[FOUND]");
                        System.out.println("Name: " + s.getFirstName() + " " + s.getLastName());
                        System.out.println("Program: " + s.getProgram());
                        System.out.println("Year Level: " + s.getYearLevel());
                        System.out.println("ID Number: " + s.getStudentId());
                        System.out.println("School Email: " + s.getSchoolEmail());
                        found = true;}
                }
            }
        }

        if (!found) {System.out.println("\nNo student found with ID number: " + id);}
    }


    // Design so that user can go back to previous level (ex. from program to school)
    // To be checked (not yet executed, logic based only)
    private static void viewMenu(){
        while (true){
            printPortal();
            System.out.print("Enter school name [enter \"exit\" to return to main menu]: ");
            String schoolChoice = input.nextLine();
            DoublyLinkedList<DoublyLinkedList<Student>> school = null;

            if (schoolChoice.equalsIgnoreCase("exit")) {
                System.out.println("Returning to Main Menu.");
                return;
            }

            // Find copy of school
            for (int x = 0; x < portal.getSize(); x++) {
                if (portal.getElement(x).getName().equalsIgnoreCase(schoolChoice)){
                    school = portal.getElement(x);
                    break;
                }
            }

            // Checks if school exists
            if (school == null){
                System.out.println("\nInvalid choice. Please try again.");
                viewMenu();
            }

            viewSchool(school);

        }
    }

    private static void viewSchool(DoublyLinkedList<DoublyLinkedList<Student>> school){
        while (true) {
            printSchool(school);
            System.out.println("Enter program name [enter \"exit\" to return to main menu OR \"prev\" to return previous menu]: ");
            String programChoice = input.nextLine();
            DoublyLinkedList<Student> program = null;

            if (programChoice.equalsIgnoreCase("exit")) {
                System.out.println("Returning to Main Menu.");
                main(null);
            } else if (programChoice.equalsIgnoreCase("prev")) {
                System.out.println("Returning to Previous Menu.");
                return;
            } else {
                // Find copy of program
                for (int x = 0; x < school.getSize(); x++) {
                    if (school.getElement(x).getName().equalsIgnoreCase(programChoice)){
                        program = school.getElement(x);
                        break;
                    }
                }

                // Checks if program exists
                if (program == null){
                    System.out.println("\nInvalid choice. Please try again.");
                    viewSchool(school);
                }

                viewProgram(program);
            }
        }
    }

    private static void viewProgram(DoublyLinkedList<Student> program){
        while (true) {
            printProgram(program);
            System.out.println("Enter ID number [enter \"exit\" to return to main menu OR \"prev\" to return previous menu]: ");
            String studentChoice = input.nextLine();
            Student student = null;

            if (studentChoice.equalsIgnoreCase("exit")) {
                System.out.println("Returning to Main Menu.");
                main(null);
            } else if (studentChoice.equalsIgnoreCase("prev")) {
                System.out.println("Returning to Previous Menu.");
                return;
            } else {
                // Find copy of student
                for (int x = 0; x < program.getSize(); x++) {
                    if (studentChoice.equalsIgnoreCase(program.getElement(x).getLastName() + program.getElement(x).getFirstName())){
                        student = program.getElement(x);
                        break;
                    }
                }

                // Checks if student exists
                if (student == null){
                    System.out.println("\nInvalid choice. Please try again.");
                    viewProgram(program);
                }

                System.out.println(student.toString());
                System.out.print("Press enter to continue.");
                input.nextLine();

                viewProgram(program);
            }

        }
    }

    private static void printPortal(){
        for (int x = 0; x < portal.getSize(); x++) {
            System.out.println((x + 1) + ". " + portal.getElement(x).getName());
        }
    }

    private static void printSchool(DoublyLinkedList<DoublyLinkedList<Student>> school){
        for (int x = 0; x < school.getSize(); x++) {
            System.out.println((x + 1) + ". " + school.getElement(x).getName());
        }
    }

    private static void printProgram(DoublyLinkedList<Student> program){
        for (int x = 0; x < program.getSize(); x++) {
            System.out.println((x + 1) + ". " + program.getElement(x).getLastName() + ", " + program.getElement(x).getFirstName());
        }
    }

}
