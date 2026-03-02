package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class BankAccountTest {
    protected BankAccount account;
    private static final int START_DEPOSIT = 1000;
    private int fee = 0;

    @BeforeEach
    void init() {
        this.account = this.getBankAccount();
        this.fee = this.getFee();
    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(START_DEPOSIT);
        assertEquals(START_DEPOSIT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int amount = 200;
        int expectedBalance = START_DEPOSIT - amount - this.fee;
        this.account.deposit(START_DEPOSIT);
        this.account.withdraw(amount);
        assertEquals(expectedBalance, this.account.getBalance());
    }

    protected abstract BankAccount getBankAccount();

    protected abstract int getFee();
}
