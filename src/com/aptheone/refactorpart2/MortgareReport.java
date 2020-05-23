package com.aptheone.refactorpart2;

import java.text.NumberFormat;

public class MortgareReport {

    private MortgageCalculator calculateMortgageCalculator;

    public MortgareReport(MortgageCalculator calculateMortgageCalculator) {
        this.calculateMortgageCalculator = calculateMortgageCalculator;
    }

    public void calculateAndPrintMortgage() {
        double mortgage = calculateMortgageCalculator.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("------------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(mortgage));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= calculateMortgageCalculator.getYears() * MortgageCalculator.MONTHS_IN_YEAR; month++) {
            double balance = calculateMortgageCalculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }
}
