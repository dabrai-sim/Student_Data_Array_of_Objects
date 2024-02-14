import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static Student addStudent() {
        System.out.println("Enter PRN:");
        String prn = scanner.next();
        System.out.println("Enter Name:");
        String name = scanner.next();
        System.out.println("Enter Date of Birth:");
        String dob = scanner.next();
        System.out.println("Enter Marks:");
        int marks = scanner.nextInt();

        return new Student(prn, name, dob, marks);
    }

    public static void displayStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("PRN: " + student.getPrn() + ", Name: " + student.getName() +
                    ", Date of Birth: " + student.getDob() + ", Marks: " + student.getMarks());
        }
    }

    public static int searchByPrn(Student[] students, String prn) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getPrn().equals(prn)) {
                return i;
            }
        }
        return -1;
    }

    public static int searchByName(Student[] students, String name) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static void updateStudentMarks(Student student) {
        System.out.println("Enter new marks for " + student.getName() + ":");
        int marks = scanner.nextInt();
        student.setMarks(marks);
        System.out.println("Marks updated successfully.");
    }

    public static void deleteStudent(Student[] students, int index) {
        for (int i = index; i < students.length - 1; i++) {
            students[i] = students[i + 1];
        }
        students[students.length - 1] = null;
        System.out.println("Student deleted successfully.");
    }
}
