package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private BankAccount goldBankAccount;
    private static final int MAX_NEGATIVE_BALANCE = -500;

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
        if(this.getBalance() - amount < MAX_NEGATIVE_BALANCE){
            throw new IllegalStateException();
        }
        this.goldBankAccount.withdraw(amount);
    }
}
