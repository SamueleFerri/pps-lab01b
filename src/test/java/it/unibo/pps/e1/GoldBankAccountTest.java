package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest {
    private GoldBankAccount account;
    private static final int START_DEPOSIT = 1000;
    private static final int MAX_OVERDRAFT = 500;

    @BeforeEach
    void init(){
        this.account = new GoldBankAccount(new CoreBankAccount());
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
        int expectedAmount = 800;
        this.account.deposit(START_DEPOSIT);
        this.account.withdraw(200);
        assertEquals(expectedAmount, this.account.getBalance());
    }

    @Test
    public void testCanOverdraft(){
        this.account.withdraw(MAX_OVERDRAFT);
        assertEquals(-MAX_OVERDRAFT, this.account.getBalance());
    }
}
