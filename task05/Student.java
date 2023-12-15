package task05;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    static Scanner scanner = new Scanner(System.in);
    String name;
    String dateOfBirth;
    String address;
    String gender;
    String fathersName;
    String mothersName;
    int rollNumber;
    int regNo;
    int grade;

    public Student(String name, String dateOfBirth, String address, String gender,
                   String fathersName, String mothersName, int rollNumber,
                   int regNo, int grade) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.fathersName = fathersName;
        this.mothersName = mothersName;
        this.rollNumber = rollNumber;
        this.regNo = regNo;
        this.grade = grade;
    }

    public String getName(){
        return name;
    }
    public int getRegNo(){
        return regNo;
    }


    public void createStudent(){
        System.out.println("\nEnter the Student's name: ");
        String name = scanner.next();

        System.out.println("\nEnter the Student's dob: ");
        String dob = scanner.next();

        System.out.println("\nEnter the Student's address: ");
        String address = scanner.next();

        System.out.println("\nEnter the Student's gender: ");
        String gender = scanner.next();

        System.out.println("\nEnter the Student's Father's name: ");
        String fathersName = scanner.next();

        System.out.println("\nEnter the Student's Mother's name: ");
        String mothersName = scanner.next();

        System.out.println("\nEnter the Student's roll number: ");
        int rollNo = scanner.nextInt();

        System.out.println("\nEnter the Student's registration number: ");
        int regNo = scanner.nextInt();

        System.out.println("\nEnter the Student's grade: ");
        int grade = scanner.nextInt();

        Student student = new Student(name, dob, address, gender, fathersName, mothersName, rollNo, regNo, grade);
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.addStudent(student);
    }

    public static void menu(){
        System.out.println("""
                1. View menu
                2. Create a new student
                3. Display All students
                4. Edit student info
                5. Delete student
                6. Search a student
                """);
    }
    public void main(String[] args) {
        System.out.println("\n Welcome to Kartik's Student Management System! ");
        menu();

        while(true){
            System.out.println("\nEnter your choice: ");
            StudentManagementSystem sms = new StudentManagementSystem();
            try{
                int response = scanner.nextInt();

                switch (response){
                    case 2:
                        createStudent();
                        break;
                    case 1:
                        menu();
                        break;
                    case 3:
                        sms.displayAllStudents();
                        break;
                    case 4:
                        System.out.println("\nEnter the student's name: ");
                        String name = scanner.next();
                        sms.editStudentInfo(name);
                        break;
                    case 5:
                        System.out.println("\nEnter the student's name: ");
                        String stuName = scanner.next();
                        sms.deleteStudentByName(stuName);
                        break;
                    case 6:
                        sms.searchStudent();
                        break;

                    default:
                        System.out.println("\nInvalid input. Please enter integers between (1 - 6).");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter integers between (1 - 6).");
            }
        }
    }

}
