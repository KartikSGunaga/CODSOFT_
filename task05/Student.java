package task05;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    static Scanner scanner = new Scanner(System.in);
    private final String name;
    private final String dateOfBirth;
    private final String address;
    private final String gender;
    private final String fathersName;
    private final String mothersName;
    private final int rollNumber;
    private final int regNo;
    private final int grade;

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
    public class StudentManagementSystem {
        private final ArrayList<Student> studentList;

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
            Student studentToEdit;
            for(Student student : this.studentList){
                if(student.getName().equals(name)){
                    while(true){
                        System.out.println("Enter the field which you wish to change(1 to stop editing):");
                        String response = scanner.next().toLowerCase();

                    }
                }
            }
        }

    }

}
