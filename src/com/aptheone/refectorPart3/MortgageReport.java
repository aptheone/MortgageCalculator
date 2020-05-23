package com.aptheone.refectorPart3;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator mortgageCalculator;

    public MortgageReport(MortgageCalculator mortgageCalculator) {
        this.mortgageCalculator = mortgageCalculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");

        double[] repaymentSchedule = mortgageCalculator.getRepaymentSchedule();
        for (double balance : repaymentSchedule) {
            System.out.println(currency.format(balance));
        }
    }

    public void calculateAndPrintMortgage() {
        double mortgage = mortgageCalculator.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("------------");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }
}
