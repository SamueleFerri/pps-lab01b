package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    private BankAccount baseBankAccount;
    private static final int FEE = 1;

    public SilverBankAccount(BankAccount bankAccount){
        this.baseBankAccount = bankAccount;
    }

    public int getBalance() {
        return baseBankAccount.getBalance();
    }

    public void deposit(int amount) {
        baseBankAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        int amountWithFee = amount + FEE;
        if (this.getBalance() < amountWithFee){
            throw new IllegalStateException();
        }
        baseBankAccount.withdraw(amountWithFee);
    }
}
