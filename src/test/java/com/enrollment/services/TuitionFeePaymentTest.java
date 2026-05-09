package com.enrollment.services;

import com.enrollment.entities.TuitionFeePayment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TuitionFeePaymentTest {

    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setUp() {
        // Keep your original variable name
        tuitionFeePayment = new TuitionFeePayment();
    }

    @Test
    void testBasicTuitionCalculation() {
        // 3 units * 1000 = 3000
        double total = tuitionFeePayment.calculateTuitionFee(3, 0.0);
        Assertions.assertEquals(3000.0, total);
    }

    @Test
    void testTuitionWithScholarship() {
        // 5 units * 1000 = 5000. 20% discount (0.20) = 4000
        double total = tuitionFeePayment.calculateTuitionFee(5, 0.20);
        Assertions.assertEquals(4000.0, total);
    }

    @Test
    void testRemainingBalanceAfterPayment() {
        tuitionFeePayment.calculateTuitionFee(4, 0.0); // 4000 total
        tuitionFeePayment.makePayment(1500.0);

        // Verifying the math: 4000 - 1500 = 2500
        Assertions.assertEquals(2500.0, tuitionFeePayment.getBalance());
    }

    @Test
    void testIsFullyPaidVerification() {
        tuitionFeePayment.calculateTuitionFee(2, 0.0); // 2000 total
        tuitionFeePayment.makePayment(2000.0);

        Assertions.assertTrue(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void testPaymentNotFinished() {
        tuitionFeePayment.calculateTuitionFee(10, 0.0); // 10000 total
        tuitionFeePayment.makePayment(5000.0);

        Assertions.assertFalse(tuitionFeePayment.isFullyPaid());
    }
}