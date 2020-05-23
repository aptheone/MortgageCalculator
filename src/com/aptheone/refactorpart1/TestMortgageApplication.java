package com.aptheone.refactorpart1;

import java.util.Scanner;

public class TestMortgageApplication {

    public static void main(String[] args) {

        var mortgage = new Mortgage();

        int principal = (int) readNumber("Please enter Principal ($1K-$1M) :", 1000, 1_000_000);
        float annualInterest = (float) readNumber("Please enter Annual Interest :", 0, 30);
        byte years = (byte) readNumber("Please enter period (years):", 0, 30);

        mortgage.setPrincipal(principal);
        mortgage.setAnnualInterest(annualInterest);
        mortgage.setYears(years);

        Mortgage.calculateAndPrintMortgage(mortgage);
        Mortgage.printPaymentSchedule(mortgage);
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

}
