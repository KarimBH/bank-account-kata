package com.github.karimbh.bankaccount.domain;

/**
 * A Bank account having an owner and a balance
 */
public class Account {

    private Client owner;

    private MonetaryAmount balance;

    public Account(Client owner, MonetaryAmount initBalance) {
        this.owner = owner;
        this.balance = initBalance;
    }

    public synchronized MonetaryAmount getBalance() {
        return balance;
    }

    public synchronized void deposit(MonetaryAmount deposit) {
        balance = balance.add(deposit);
    }

    /**
     * Withdraws an amount of money from account's balance.
     * <p>
     * Note: No checking on withdrawal > balance is done. To be specified
     * </p>
     * @param withdrawal
     */
    public synchronized void withdraw(MonetaryAmount withdrawal) {
        balance = balance.subtract(withdrawal);
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

}
