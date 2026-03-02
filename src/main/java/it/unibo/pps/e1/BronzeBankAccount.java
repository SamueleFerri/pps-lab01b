package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {
    private BankAccount baseBankAccount;
    private static final int CONDITION_FEE = 100;

    public BronzeBankAccount(BankAccount bankAccount){
        this.baseBankAccount = bankAccount;
    }

    public int getBalance() {
        return baseBankAccount.getBalance();
    }

    public void deposit(int amount) {
        baseBankAccount.deposit(amount);
    }

    public void withdraw(int amount) {
        int amountWithFee = amount + this.getFee(amount);
        if (this.getBalance() < amountWithFee){
            throw new IllegalStateException();
        }
        baseBankAccount.withdraw(amountWithFee);
    }

    public int getFee(int amount){
        int fee = 0;
        if(amount > CONDITION_FEE){
            fee = 1;
        }
        return fee;
    }
}
