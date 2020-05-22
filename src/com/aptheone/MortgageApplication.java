package com.aptheone;

import java.text.NumberFormat;
import java.util.Scanner;

public class  MortgageApplication {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {
        int principal = (int) readNumber("Please enter Principal ($1K-$1M) :", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Please enter Annual Interest :", 0, 30);
        byte years = (byte) readNumber("Please enter period (years):", 0, 30);

        calculateAndPrintMortgage(principal, annualInterest, years);
        printPaymentSchedule(principal, annualInterest, years);
    }

    private static void calculateAndPrintMortgage(int principal, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principal, annualInterest, years);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("------------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(principal, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
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
            }catch (NumberFormatException numberFormatException){
                System.out.print("Please enter a number between " + min + "and " + max);
                System.out.println();
            }
        }
        return value;
    }

    public static double calculateBalance(int principal, float annualInterest, byte years, short numberOfPaymentsMade) {
        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        return principal * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade)) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }

    public static double calculateMortgage(int principal, float annualInterest, byte years) {

        float monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = years * MONTHS_IN_YEAR;

        return principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }


}
