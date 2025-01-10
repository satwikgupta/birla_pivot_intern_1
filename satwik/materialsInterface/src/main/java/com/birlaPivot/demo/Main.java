package com.birlaPivot.demo;

import com.birlaPivot.demo.models.Cement;
import com.birlaPivot.demo.models.Material;
import com.birlaPivot.demo.models.SteelBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Order management----\n");

        List<Material> orders = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter 1 for cement orders... ");
            System.out.println("Enter 2 for steel bars orders... ");
            System.out.println("Enter 0 to exit.");
            System.out.print("\nEnter here: ");

            int choice = scanner.nextInt();

            if(choice == 0) break;
            else if(choice == 1){
                System.out.print("Enter price for cement: ");
                int price = scanner.nextInt();
                System.out.print("Enter margin for cement: ");
                int margin = scanner.nextInt();
                System.out.print("Enter number of bags for cement: ");
                int numberOfBags = scanner.nextInt();

                orders.add(new Cement(price, margin, numberOfBags));
                System.out.println("Cement order added. \n\n");
            }
            else if(choice == 2){
                System.out.print("Enter price for steel bars: ");
                int price = scanner.nextInt();
                System.out.print("Enter margin for steel bars: ");
                int margin = scanner.nextInt();
                System.out.print("Enter number of units for steel bars: ");
                int units = scanner.nextInt();

                orders.add(new SteelBar(price, margin, units));

                System.out.println("Steel bars order added.\n\n");
            }else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.println("\nAll Orders:");
        int sumTotal = 0;

        orders.stream().forEach(order -> System.out.println(order));

        scanner.close();  // Close the scanner
        System.out.println("Exiting Order Management System...");
    }

}
