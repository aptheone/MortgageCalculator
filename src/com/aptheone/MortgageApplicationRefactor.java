package com.aptheone;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageApplicationRefactor {

    public static void main(String[] args) {
        int principal = (int) readNumber("Please enter Principal ($1K-$1M) :", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Please enter Annual Interest :", 0, 30);
        byte years = (byte) readNumber("Please enter period (years):", 0, 30);

        double mortgage = calculateMortgage(principal, annualInterest, years);
        System.out.println("Mortgage : " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value > min && value <= max) {
                break;
            }
            System.out.print("Please enter a number between " + min + "and " + max);
        }
        return value;
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double factor = Math.pow((1 + monthlyInterest), numberOfPayments);
        return principal * (monthlyInterest * factor) /
                (factor - 1);
    }

}
