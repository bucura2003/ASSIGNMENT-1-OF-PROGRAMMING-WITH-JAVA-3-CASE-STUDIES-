package attendance;

import java.util.Scanner;

public class ClassAttendanceTracker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);


		System.out.print("Enter total number of students in the class: ");
		int totalStudents = sc.nextInt();

		int[] attendance = new int[30];
		int dayCount = 0;


		String choice = null;
		do {
			if (dayCount >= 30) {
				System.out.println("Maximum of 30 days reached!");
				break;
			}

			System.out.print("Enter number of students present on day " + (dayCount + 1) + ": ");
			int present = sc.nextInt();


			if (present < 0 || present > totalStudents) {
				System.out.println("Invalid number. Must be between 0 and " + totalStudents);
				continue; 
			}

			attendance[dayCount] = present;
			dayCount++;

			System.out.print("Do you want to enter attendance for another day? (yes/no): ");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("yes"));


		int totalPresent = 0;
		int lowAttendanceDays = 0;

		for (int i = 0; i < dayCount; i++) {
			totalPresent += attendance[i];
			if (attendance[i] < totalStudents * 0.5) {
				lowAttendanceDays++;
			}
		}

		double averageAttendance = (dayCount > 0) ? (double) totalPresent / dayCount : 0.0;
		double lowAttendancePercent = (dayCount > 0) ? (lowAttendanceDays * 100.0 / dayCount) : 0.0;


		System.out.println("\n========== Attendance Summary ==========");
		System.out.printf("%-10s %-20s\n", "Day", "Students Present");
		for (int i = 0; i < dayCount; i++) {
			System.out.printf("%-10d %-20d\n", (i + 1), attendance[i]);
		}

		System.out.println("-----------------------------------------");
		System.out.printf("Average Attendance : %.2f students\n", averageAttendance);
		System.out.printf("Days Below 50%%     : %d (%.2f%% of total days)\n",
				lowAttendanceDays, lowAttendancePercent);
		System.out.println("=========================================");

		sc.close();
	}
}
