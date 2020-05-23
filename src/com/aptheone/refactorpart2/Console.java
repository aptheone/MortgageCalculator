package com.aptheone.refactorpart2;

import java.util.Scanner;

public class Console {

    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt) {

        return Double.parseDouble(scanner.nextLine().trim());
    }

    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Double.parseDouble(scanner.nextLine().trim());
                if (value > min && value <= max) {
                    break;
                }
                System.out.print("Please enter a number between " + min + "and " + max);
                System.out.println();
            } catch (NumberFormatException numberFormatException) {
                System.out.print("Please enter a number between " + min + "and " + max);
                System.out.println();
            }
        }
        return value;
    }
}
