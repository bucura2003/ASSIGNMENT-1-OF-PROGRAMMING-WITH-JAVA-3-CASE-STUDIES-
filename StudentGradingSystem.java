package GradingSystem;

import java.util.Scanner;

public class StudentGradingSystem {

	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalStudents = 0;
        int passes = 0;
        int fails = 0;

        System.out.println("Enter student marks (0–100). Enter -1 to stop.");

        while (true) {
            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            // 2. Stop if sentinel value (-1) is entered
            if (marks == -1) {
                break;
            }

            // Validate marks range
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter between 0 and 100, or -1 to stop.");
                continue; // skip to next iteration
            }

            totalStudents++;

            // 3. Determine grade
            String grade;
            if (marks >= 80) {
                grade = "A";
            } else if (marks >= 70) {
                grade = "B";
            } else if (marks >= 60) {
                grade = "C";
            } else if (marks >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display grade immediately
            System.out.println("Grade: " + grade);

            // 4. Count passes and fails
            if (marks >= 50) {
                passes++;
            } else {
                fails++;
            }
        }

        // 5. Summary report
        System.out.println("\n========= Summary Report =========");
        System.out.println("Total Students : " + totalStudents);
        System.out.println("Passed         : " + passes);
        System.out.println("Failed         : " + fails);

        double passRate = (totalStudents > 0) ? (passes * 100.0 / totalStudents) : 0.0;
        System.out.printf("Class Pass Rate: %.2f%%\n", passRate);
        System.out.println("==================================");

        sc.close();
    }
}
