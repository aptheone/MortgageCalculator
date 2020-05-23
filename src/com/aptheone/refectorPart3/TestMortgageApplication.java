package com.aptheone.refectorPart3;

import com.aptheone.refactorpart2.MortgareReport;

public class TestMortgageApplication {

    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Please enter Principal ($1K-$1M) :", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Please enter Annual Interest :", 0, 30);
        byte years = (byte) Console.readNumber("Please enter period (years):", 0, 30);

        var mortgageCalculator = new MortgageCalculator(principal, annualInterest, years);

        var mortgageReport = new MortgageReport(mortgageCalculator);
        mortgageReport.calculateAndPrintMortgage();
        mortgageReport.printPaymentSchedule();
    }


}
