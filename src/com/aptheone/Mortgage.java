package com.aptheone;

import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float annualInterest = 0.0F;
        float monthlyInterest = 0.0F;
        byte period = 0;
        int numberOfPayments = 0;

        while (true) {
                System.out.print("Please enter Principal ($1K-$1M) :");
                principal = scanner.nextInt();
            if (principal >= 1000 || principal <1_000_000)
                break;
            System.out.print("Please enter a number between 1,000 to 1,000,000.:");
        }

        while (true) {
            System.out.print("Please enter Annual Interest :");
            annualInterest = scanner.nextFloat();
            if(annualInterest > 0.0F || annualInterest <= 30.0F) {
                monthlyInterest = annualInterest / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.print("Please enter a number between 0.0 to 30:");
        }
        while (true) {
            System.out.print("Please enter Period :");
            period = scanner.nextByte();
            if (period > 1 || period <= 30) {
                numberOfPayments = period * MONTHS_IN_YEAR;
                break;
            }
            System.out.print("Please enter a number between 1 to 30:");
        }
        double mortgage = principal * (monthlyInterest * Math.pow((1 + monthlyInterest), numberOfPayments)) /
                (Math.pow((1 + monthlyInterest), numberOfPayments) - 1);
        System.out.println("Mortgage : " + NumberFormat.getCurrencyInstance().format(mortgage));

    }

}
