package BillingSystem;

import java.util.Scanner;

public class SupermarketBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of different items: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        
        String[] itemNames = new String[n];
        double[] prices = new double[n];
        int[] quantities = new int[n];
        double[] subtotals = new double[n];

        double grandTotal = 0;

        
        for (int i = 0; i < n; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("Enter item name: ");
            itemNames[i] = sc.nextLine();

            System.out.print("Enter price per unit: ");
            prices[i] = sc.nextDouble();

            System.out.print("Enter quantity purchased: ");
            quantities[i] = sc.nextInt();
            sc.nextLine(); 

            
            subtotals[i] = prices[i] * quantities[i];
            grandTotal += subtotals[i];
        }

        
        double discount = 0;
        if (grandTotal > 50000) {
            discount = grandTotal * 0.05; 
        }
        double finalAmount = grandTotal - discount;

        
        System.out.println("\n=========== RECEIPT ===========");
        System.out.printf("%-15s %-10s %-12s %-10s\n",
                          "Item", "Quantity", "Price/Unit", "Subtotal");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s %-10d %-12.2f %-10.2f\n",
                              itemNames[i], quantities[i], prices[i], subtotals[i]);
        }

        System.out.println("----------------------------------------------");
        System.out.printf("Grand Total : %.2f\n", grandTotal);
        System.out.printf("Discount    : %.2f\n", discount);
        System.out.printf("Final Amount: %.2f\n", finalAmount);
        System.out.println("==============================================");

        sc.close();
		

	}

}

