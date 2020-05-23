package com.aptheone.refactorpart1;

import java.text.NumberFormat;

public class Mortgage {

    public static byte MONTHS_IN_YEAR = 12;
    public static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public float getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    public byte getYears() {
        return years;
    }

    public void setYears(byte years) {
        this.years = years;
    }

    public static double calculateMortgage(Mortgage mortgage) {

        float monthlyInterest = mortgage.getAnnualInterest() / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = mortgage.getYears() * MONTHS_IN_YEAR;

        return mortgage.getPrincipal() * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }

    public static void calculateAndPrintMortgage(Mortgage mortgage) {
        double value =calculateMortgage(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("------------");
        System.out.println("Monthly Payments: " + NumberFormat.getCurrencyInstance().format(value));
    }
    public static void printPaymentSchedule(Mortgage mortgage) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= mortgage.getYears() * MONTHS_IN_YEAR; month++) {
            double balance = calculateBalance(mortgage, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double calculateBalance(Mortgage mortgage, short numberOfPaymentsMade) {
        float monthlyInterest = mortgage.getAnnualInterest() / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = mortgage.getYears() * MONTHS_IN_YEAR;

        return mortgage.getPrincipal() * (Math.pow((1 + monthlyInterest), numberOfPayments) - Math.pow((1 + monthlyInterest), numberOfPaymentsMade)) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
    }

}
