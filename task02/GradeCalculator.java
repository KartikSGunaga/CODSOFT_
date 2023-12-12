package task02;

import java.util.Scanner;

public class GradeCalculator {
    static int MAX_MARKS = 100;
    static int SUBJECTS = 6;

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the Grade Calculator!");

        float[] markList = getMarks();
        float total = calculateTotalMarks(markList);
        float percentageObtained = calculateAveragePercentage(total);
        String gradeObtained = assignGrade(percentageObtained);

        displayGrade(gradeObtained, total, percentageObtained);

    }
    public static float[] getMarks(){
        System.out.println("Please enter the marks of " + SUBJECTS + " subjects.");
        float[] markList = new float[SUBJECTS];

        for(int i = 0; i < SUBJECTS; i++){
            System.out.println("Marks in subject " + (i+1) + ": ");
            markList[i] = scanner.nextFloat();
        }
        return markList;
    }

    public static float calculateTotalMarks(float[] markList){
        int length = markList.length;
        float total = 0;

        for(int i =0; i < length; i++){
            total += markList[i];
        }
        return total;
    }

    public static float calculateAveragePercentage(float total){
        int maxMarks = SUBJECTS * MAX_MARKS;

        return (float) (Math.round((total / maxMarks) * 100.0 * 100.0) / 100.0);

    }

    public static String assignGrade(float percentage){
        if(percentage > 90){
            return "A";
        } else if (percentage > 80){
            return "B";
        } else if (percentage > 70){
            return "C";
        } else if (percentage > 60) {
            return "D";
        } else{
            return "F";
        }
    }
    public static void displayGrade(String grade, float total, float percentage){
        System.out.println("Total Marks: " + total);
        System.out.println(percentage +"% obtained.");
        System.out.println("Grade " + grade + " obtained.");
    }

}
