package com.aptheone.refactorpart2;

public class MortgageApplication {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Please enter Principal ($1K-$1M) :", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Please enter Annual Interest :", 0, 30);
        byte years = (byte) Console.readNumber("Please enter period (years):", 0, 30);

        var calculateMortgageCalculator= new MortgageCalculator(principal,annualInterest,years);

        var mortgageReport = new MortgareReport(calculateMortgageCalculator);
        mortgageReport.calculateAndPrintMortgage();
        mortgageReport.printPaymentSchedule();
    }


}
