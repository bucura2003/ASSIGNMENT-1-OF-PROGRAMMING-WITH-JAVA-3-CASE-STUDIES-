package Com.shapes;

import java.util.Scanner;

public class Shapes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println("\nChoose the shape:");
			System.out.println("1. Rectangle");
			System.out.println("2. Circle");
			System.out.println("3. Square");
			System.out.println("4. Triangle");
			System.out.print("Enter choice (1-4): ");
			int shapeChoice = sc.nextInt();

			System.out.println("\nWhat would you like to calculate:");
			System.out.println("1. Area");
			System.out.println("2. Perimeter");
			System.out.print("Enter choice (1 or 2): ");
			int calcChoice = sc.nextInt();

			double result = 0.0;

			switch (shapeChoice) {
			case 1: // Rectangle
				System.out.print("Enter length: ");
				double length = sc.nextDouble();
				System.out.print("Enter width: ");
				double width = sc.nextDouble();
				if (calcChoice == 1) {
					result = length * width;
				} else {
					result = 2 * (length + width);
				}
				break;

			case 2: // Circle
				System.out.print("Enter radius: ");
				double radius = sc.nextDouble();
				if (calcChoice == 1) {
					result = Math.PI * radius * radius;
				} else {
					result = 2 * Math.PI * radius;
				}
				break;

			case 3: // Square
				System.out.print("Enter side: ");
				double side = sc.nextDouble();
				if (calcChoice == 1) {
					result = side * side;
				} else {
					result = 4 * side;
				}
				break;

			case 4: // Triangle
				if (calcChoice == 1) {
					System.out.print("Enter base: ");
					double base = sc.nextDouble();
					System.out.print("Enter height: ");
					double height = sc.nextDouble();
					result = 0.5 * base * height;
				} else {
					System.out.println("Enter three sides:");
					double a = sc.nextDouble();
					double b = sc.nextDouble();
					double c = sc.nextDouble();
					result = a + b + c;
				}
				break;

			default:
				System.out.println("Invalid shape choice!");
				continue;
			}

			// Display result
			if (calcChoice == 1) {
				System.out.println("\nArea = " + result);
			} else {
				System.out.println("\nPerimeter = " + result);
			}

			// Ask if the user wants to continue
			System.out.print("\nWould you like to continue? (Yes/No): ");
			String again = sc.next();
			if (!again.equalsIgnoreCase("Yes")) {
				keepGoing = false;
				System.out.println("Thank you.");
			}
		}
		sc.close();
	}
}

