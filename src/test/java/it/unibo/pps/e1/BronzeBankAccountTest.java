package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeBankAccountTest extends BankAccountTest {
    private static final int START_DEPOSIT = 1000;
    private static final int CODITION_FEE = 100;

    @Override
    protected BankAccount getBankAccount() {
        return new BronzeBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getFee(int amount) {
        return amount > CODITION_FEE ? 1 : 0;
    }

    @Test
    public void testWithdrawWithoutFee(){
        int amount = 50;
        int expectedBalance = START_DEPOSIT - amount;
        this.account.deposit(START_DEPOSIT);
        this.account.withdraw(amount);
        assertEquals(expectedBalance, this.account.getBalance());
    }
}
