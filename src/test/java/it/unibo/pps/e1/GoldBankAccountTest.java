package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends BankAccountTest {
    private static final int MAX_OVERDRAFT = 500;
    private static final int FEE = 0;

    @Override
    protected BankAccount getBankAccount() {
        return new GoldBankAccount(new CoreBankAccount());
    }

    @Override
    protected int getFee() {
        return this.FEE;
    }

    @Test
    public void testCanOverdraft(){
        this.account.withdraw(MAX_OVERDRAFT);
        assertEquals(-MAX_OVERDRAFT, this.account.getBalance());
    }

    @Test
    public void testCannotWithDrawOverMaxOverdraft(){
        int amount = 200;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(MAX_OVERDRAFT + amount));
    }
}
