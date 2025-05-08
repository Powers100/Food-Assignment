/*  
   Assignment: Restaurant Food Ordering System
   FoodPowers.java
   Name: Donovan Powers
   Description: An application that presents the customer with a menu of the restaurant, lets them 
                choose the dishes from the menu, and shows them the total price of the order.
   Due Date: February 23, 2025
   File Created: February 13, 2025
*/

import java.util.Scanner;

public class FoodPowers {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //Menu items and prices
        String[] menuItems = {
                "Chickpea Curry", "Pad Thai", "Naan",
                "Stuffed Bell Peppers", "Mushroom Risotto",
                "Buffalo Bites", "Shepherd's Pie", "BBQ Sandwich",
                "Chana Masala", "Coconut Rice Pudding"
        };

        double[] menuPrices = {12.99, 13.49, 3.99, 8.99, 14.99, 9.99, 12.49, 11.99, 10.99, 5.49};

        System.out.println("Food Menu");
        System.out.printf("%8s\t\t %s\n", "Item", "Price (in dollars)");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-3d %-20s $%.2f%n", i + 1, menuItems[i], menuPrices[i]);
        }

        // Asking for number of different dishes
        System.out.print("\nHow many different dishes would you like to order today? ");
        int numDishes = scnr.nextInt();

        if (numDishes >= 1) {

            double subtotal = 0;
            int i = 1;

            // Ordering loop
            while (i <= numDishes) {
                System.out.printf("Enter dish %d [1-10]: ", i);
                int dishChoice = scnr.nextInt();

                if (dishChoice < 1 || dishChoice > 10) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 10.");
                    continue;
                }

                System.out.printf("How many servings of dish %d would you like to order? ", dishChoice);
                int servings = scnr.nextInt();

                subtotal += menuPrices[dishChoice - 1] * servings;
                i++;
            }

            // Asking for tax percentage
            System.out.print("Enter the tax %: ");
            double taxRate = scnr.nextDouble() / 100;
            double tax = subtotal * taxRate;

            // Asking for tip
            System.out.print("Do you want to add tip? ['y' - yes or 'n' - no] ");
            char tipChoice = scnr.next().charAt(0);
            double tip = 0.0;
            double tipRate = 0.0;

            switch (tipChoice) {
                case 'y':
                case 'Y':
                    System.out.print("Enter tip % [0-100]: ");
                    tipRate = scnr.nextDouble();
                    tip = (subtotal + tax) * (tipRate / 100);
                    break;
                case 'n':
                case 'N':
                    // No tip will be added if the user answers 'n' or 'N'
                    tip = 0;
                    break;
                default:
                    System.out.println("Invalid option. No tip will be added.");
                    break;
            }

            // Manual rounding to two decimal places
            subtotal = (int) (subtotal * 1000);
            int lastDigit = (int) (subtotal % 10);
            if (lastDigit >= 5) {
                subtotal += 10;
            }
            subtotal = (int) (subtotal / 10);
            subtotal = subtotal / 100.0;

            tax = (int) (tax * 1000);
            lastDigit = (int) (tax % 10);
            if (lastDigit >= 5) {
                tax += 10;
            }
            tax = (int) (tax / 10);
            tax = tax / 100.0;

            tip = (int) (tip * 1000);
            lastDigit = (int) (tip % 10);
            if (lastDigit >= 5) {
                tip += 10;
            }
            tip = (int) (tip / 10);
            tip = tip / 100.0;

            double totalAmount = subtotal + tax + tip;

            // Printing final bill
            System.out.println("\n- - - - - - - - --");
            System.out.printf("Price: %.2f%n", subtotal);
            System.out.printf("Tax (%.1f%%): %.2f%n", taxRate * 100, tax);
            System.out.printf("Tip (%.1f%%): %.2f%n", tipRate, tip);
            System.out.println("- - - - - - - - --");
            System.out.printf("Total Amount: $%.2f%n", totalAmount);
            System.out.println("\n\tYour order has been placed and will be delivered soon!");

        }

        else {
            System.out.print("No Order Placed");
        }
        scnr.close();
    }
}
