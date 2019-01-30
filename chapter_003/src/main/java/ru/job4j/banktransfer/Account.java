package ru.job4j.banktransfer;

/**
 * Class for creating account for users.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.01.2019
 * @version 1.0
 */
public class Account {

    /**
     * Amount of user's money.
     */
    private double value;

    /**
     * User's requisites.
     */
    private String requisites;

    /**
     * The constructor.
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Returns user's value.
     * @return value
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Returns user's requisites.
     * @return requisites
     */
    public String getRequisites() {
        return this.requisites;
    }

    /**
     * Sets a new amount of money.
     * @param money - a new amount of money
     */
    public void setValue(double money) {
        this.value += money;
    }

    /**
     * Transfers the money from this account to another one.
     * @param dest an account the money to be transferred to
     * @param amount amount of money
     * @return true - if success, false - otherwise
     */
    public boolean transfer(Account dest, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.value && dest != null) {
            dest.setValue(amount);
            this.value -= amount;
            result = true;
        }
        return result;
    }

    /**
     * Overriding the "equals method" for Account class.
     * @param anObject - an account to be compared
     * @return true - if accounts equals each other, false - otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        boolean result = false;
        if (anObject instanceof Account) {
            Account account = (Account) anObject;
            if (this.getRequisites().equals(account.getRequisites()) && this.getValue() == account.getValue()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Overriding the "hashCode method" for User class.
     * @return a hashCode
     */
    @Override
    public int hashCode() {
        return this.getRequisites().hashCode();
    }

    /**
     * Overriding the "toString" method for Account class.
     * @return String - Account's information
     */
    @Override
    public String toString() {
        return "Account value " + this.getValue() + " Requisites: " + this.getRequisites();
    }
}