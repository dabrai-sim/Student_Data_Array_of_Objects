//Simrann Dabrai 22070126111 B2
import java.util.Scanner;

public class Main {
    private static final int MAX_STUDENTS = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[MAX_STUDENTS];
        int count = 0;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Update Student Marks");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (count < MAX_STUDENTS) {
                        students[count++] = UserInput.addStudent();
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Cannot add more students. Array is full.");
                    }
                    break;
                case 2:
                    UserInput.displayStudents(students);
                    break;
                case 3:
                    System.out.println("Enter PRN to search:");
                    String prn = scanner.next();
                    int indexByPrn = UserInput.searchByPrn(students, prn);
                    if (indexByPrn != -1) {
                        System.out.println("Student found at index: " + indexByPrn);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Name to search:");
                    String name = scanner.next();
                    int indexByName = UserInput.searchByName(students, name);
                    if (indexByName != -1) {
                        System.out.println("Student found at index: " + indexByName);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter PRN of student to update marks:");
                    String prnToUpdate = scanner.next();
                    int indexToUpdate = UserInput.searchByPrn(students, prnToUpdate);
                    if (indexToUpdate != -1) {
                        UserInput.updateStudentMarks(students[indexToUpdate]);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.out.println("Enter PRN of student to delete:");
                    String prnToDelete = scanner.next();
                    int indexToDelete = UserInput.searchByPrn(students, prnToDelete);
                    if (indexToDelete != -1) {
                        UserInput.deleteStudent(students, indexToDelete);
                        count--;
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 7:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
