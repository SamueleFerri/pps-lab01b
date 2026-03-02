package it.unibo.pps.e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends BankAccountTest {
    private static final int START_DEPOSIT = 1000;
    private static final int FEE = 1;

    @Override
    protected BankAccount getBankAccount() {
        return new SilverBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getFee(int amount) {
        return this.FEE;
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(START_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

}
