package com.enrollment.services.impl;

import com.enrollment.services.ITuitionService;

public class TuitionServiceImpl implements ITuitionService {
    private double balance = 0;

    @Override
    public double calculateFee(int units) {
        double fee = units * 1500.0;
        this.balance += fee;
        return fee;
    }

    @Override
    public double getRemainingBalance() {
        return balance;
    }
}