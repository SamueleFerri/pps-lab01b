package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount{

    private BankAccount goldBankAccount;

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
        this.goldBankAccount.withdraw(amount);
    }
}
