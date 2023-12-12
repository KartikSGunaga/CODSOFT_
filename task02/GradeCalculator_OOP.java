package task02;

import java.util.Scanner;
public class GradeCalculator_OOP {
    static Scanner scanner = new Scanner(System.in);
    float [] markList;
    float total = 0, percentage;

    public GradeCalculator_OOP(int numOfSubjects){
        this.markList = new float[numOfSubjects];
    }

    public float totalCalculator(){
        for(int i = 0; i < this.markList.length; i++){
            System.out.println("Enter the marks in subject " + (i+1) + " (out of 100): ");
            int mark = scanner.nextInt();
            markList[i] = mark;
            total += mark;
        }
        return total;
    }

    public float percentageCalculator(){
        percentage =  total / this.markList.length;
        return percentage;
    }

    public void gradeCalculator(){
        if (percentage >= 90) {
            System.out.println("Grade obtained: A+");
        } else if (percentage >= 80) {
            System.out.println("Grade obtained: B");
        } else if (percentage >= 70) {
            System.out.println("Grade obtained: C");
        } else if (percentage >= 60) {
            System.out.println("Grade obtained: D");
        } else {
            System.out.println("Grade obtained: F");
        }
    }
    public void displayResults(){
        float totalMarks, percentObtained;

        totalMarks = totalCalculator();
        percentObtained = percentageCalculator();

        System.out.println("Total marks: " + totalMarks);
        System.out.println("Average Percentage: " + percentObtained);
        gradeCalculator();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Grade Calculator!");

        while(true) {
            System.out.println("Press 1 to calculate the grade, 2 to exit: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter the total subjects: ");
                int totalSubjects = scanner.nextInt();

                GradeCalculator_OOP studentMarks = new GradeCalculator_OOP(totalSubjects);
                studentMarks.displayResults();
            } else if (choice == 2) {
                System.out.println("Thank you");
                break;
            } else
                System.out.println("Invalid choice; Enter either 1 or 2 only.");
        }
    }
}
