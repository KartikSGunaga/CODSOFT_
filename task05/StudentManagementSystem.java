package task05;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {
    private final ArrayList<Student> studentList;
    Scanner scanner = new Scanner(System.in);

    public StudentManagementSystem(){
        this.studentList = new ArrayList<>();
    }
    public void addStudent(Student student){
        this.studentList.add(student);
    }
    public void deleteStudentByName(String name){
        Student studentToRemove = null;
        for(Student student : this.studentList){
            if(student.getName().equals(name)){
                studentToRemove = student;
                this.studentList.remove(student);
                break;
            }
        }
        if(studentToRemove != null){
            System.out.println("Student successfully removed.");
        }
        else
            System.out.println("Student not found.");
    }
    public void deleteStudentByRegNo(int reg){
        Student studentToRemove = null;
        for(Student student : this.studentList){
            if(student.getRegNo() == reg){
                studentToRemove = student;
                break;
            }
        }
        if(studentToRemove != null){
            System.out.println("Student removed successfully.");
        }
        else
            System.out.println("Student not found.");
    }


    public void editStudentInfo(String name){
        for(Student student : this.studentList){
            if(student.getName().equals(name)){
                while(true){
                    System.out.println("Enter the field which you " +
                            "wish to change(type \"stop\" to stop editing):");
                    String response = scanner.next().toLowerCase();

                    if(response.equals("name")){
                        System.out.println("\nEnter the modified name: ");
                        student.name = scanner.next();
                    }
                    else if(response.equals("date of birth")){
                        System.out.println("\nEnter the modified address: ");
                        student.dateOfBirth = scanner.next();
                    }
                    else if(response.equals("gender")){
                        System.out.println("\nEnter the modified gender: ");
                        student.gender = scanner.next();
                    }
                    else if(response.equals("address")){
                        System.out.println("\nEnter the modified address: ");
                        student.gender = scanner.next();
                    }
                    else if(response.equals("roll number")){
                        System.out.println("\nEnter the modified roll number:  ");
                        student.rollNumber = scanner.nextInt();
                    }
                    else if(response.equals("reg no")){
                        System.out.println("\nEnter the modified roll number:  ");
                        student.regNo = scanner.nextInt();
                    }
                    else if(response.equals("grade")){
                        System.out.println("\nEnter the modified roll number:  ");
                        student.grade = scanner.nextInt();
                    }
                    else if(response.equals("father's name")){
                        System.out.println("\nEnter the modified roll number:  ");
                        student.fathersName = scanner.next();
                    }
                    else if(response.equals("mother's name")){
                        System.out.println("\nEnter the modified roll number:  ");
                        student.mothersName = scanner.next();
                    }
                    else if(response.equals("stop")){
                        break;
                    }
                    else{
                        System.out.println("Invalid choice entered. Try again");
                    }

                }
            }
        }
    }
    public void searchStudent(){
        System.out.println("""
                    Press 1 to search student by name
                    Press 2 to search by registration number:\s""");
        int choice = scanner.nextInt();

        if(choice == 1){
            System.out.println("Enter the student's name: ");
            String studentName = scanner.next().toLowerCase();

            for(Student student: studentList){
                if(student.name.equals(studentName)){
                    System.out.println("Here are the details: ");
                    System.out.println("Name: " + student.name);
                    System.out.println("Birthday: " + student.dateOfBirth);
                    System.out.println("Address: " + student.address);
                    System.out.println("Gender: " + student.gender);
                    System.out.println("Father's name: " + student.fathersName);
                    System.out.println("Mother's name: " + student.mothersName);
                    System.out.println("Roll number: " + student.rollNumber);
                    System.out.println("Registration number: " + student.regNo);
                    System.out.println("Grade: " + student.grade);
                }
            }
        } else if (choice == 2) {
            System.out.println("enter student's registration number: ");
            int registNo = scanner.nextInt();

            for(Student student: studentList){
                if(student.regNo == registNo){
                    System.out.println("Here are the details: ");
                    System.out.println("Name: " + student.name);
                    System.out.println("Birthday: " + student.dateOfBirth);
                    System.out.println("Address: " + student.address);
                    System.out.println("Gender: " + student.gender);
                    System.out.println("Father's name: " + student.fathersName);
                    System.out.println("Mother's name: " + student.mothersName);
                    System.out.println("Roll number: " + student.rollNumber);
                    System.out.println("Registration number: " + student.regNo);
                    System.out.println("Grade: " + student.grade);
                }
            }
        }
    }
    public void displayAllStudents(){
        for(Student student: studentList){
            System.out.println("\n" + student.name);
        }
    }

}
