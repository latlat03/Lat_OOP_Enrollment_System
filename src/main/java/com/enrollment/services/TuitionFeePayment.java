package com.enrollment.services;

public class TuitionFeePayment {
    private final double PRICE_PER_UNIT = 1000.0;
    private double balance;
    private double totalTuitionFee;

    public double calculateTuitionFee(int units, double discountPercent) {
        totalTuitionFee = units * PRICE_PER_UNIT;
        if (discountPercent > 0) {
            totalTuitionFee -= (totalTuitionFee * discountPercent);
        }
        balance = totalTuitionFee;
        return totalTuitionFee;
    }

    public void makePayment(double amount) {
        balance -= amount;
    }

    public double getBalance() { return balance; }

    public boolean isFullyPaid() {
        return balance <= 0;
    }
}