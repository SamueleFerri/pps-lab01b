package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private BankAccount goldBankAccount;
    private static final int MAX_NEGATIVE_BALANCE = -500;
    private static final int FEE = 0;

    public GoldBankAccount(BankAccount bankAccount) {
        this.goldBankAccount = bankAccount;
    }

    @Override
    public int getBalance() {
        return goldBankAccount.getBalance();
    }

    @Override
    public void deposit(int amount) {
        this.goldBankAccount.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int amountWithFee = amount + FEE;
        if(this.getBalance() - amountWithFee < MAX_NEGATIVE_BALANCE){
            throw new IllegalStateException();
        }
        this.goldBankAccount.withdraw(amountWithFee);
    }
}
