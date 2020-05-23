package com.aptheone.refectorPart3;

import java.text.NumberFormat;

public class MortgageCalculator {

    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double[] getRepaymentSchedule() {

        var shcedules = new double[getNumberOfPayments()];

        for (short month = 1; month <= shcedules.length; month++) {
            shcedules[month - 1] = calculateBalance(month);
        }
        return shcedules;
    }


    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        return principal * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade)) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        int numberOfPayments = getNumberOfPayments();

        return principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }

    private float getMonthlyInterest() {
        return annualInterest / MONTHS_IN_YEAR / PERCENT;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }
    
}
