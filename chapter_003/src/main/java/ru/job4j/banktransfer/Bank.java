package ru.job4j.banktransfer;

import java.util.*;

/**
 * Class for storing information about users and their account.
 *
 * @author Dmitrii Eskov (eskovdmi@gmail.com)
 * @since 30.01.2019
 * @version 1.0
 */
public class Bank {

    /**
     * Storage for users and their information.
     */
    private Map<User, List<Account>> map = new TreeMap<>();

    /**
     * Add a new user to this.map
     * @param user a new user
     */
    public void addUser(User user) {
        this.map.put(user, new ArrayList<>());
    }

    /**
     * Deletes a user from this.map
     * @param user a user to be deleted
     */
    public void deleteUser(User user) {
        this.map.remove(user);
    }

    /**
     * Adds a new account for a user.
     * @param passport - a user's passport
     * @param account - a user's account
     */
    public void addAccountToUser(String passport, Account account) {
        User user = this.map.keySet().stream().filter(
                value -> value.getPassport().equals(passport)).findAny().orElse(null);
        this.map.get(user).add(account);    }

    /**
     * Deletes a user's account.
     * @param passport - a user's passport
     * @param account - a user's account
     */
    public boolean deleteAccountFromUser(String passport, Account account) {
       return this.map.keySet().stream().anyMatch(
                user -> user.getPassport().equals(passport) && this.map.get(user).remove(account)
       );
    }

    /**
     * Returns all user's accounts.
     * @param passport - a user's passport
     * @return a list of user's accounts
     */
    public List<Account> getUserAccounts(String passport) {
        return this.map.entrySet().stream().filter(
                user -> user.getKey().getPassport().equals(passport)
        ).map(
                Map.Entry :: getValue
        ).findAny().orElse(null);
    }

    /**
     * Returns a user's account.
     * @param passport - a user's passport
     * @return a user's account
     * @throws ArrayIndexOutOfBoundsException - when object.getValue().indexOf(account) == -1
     */
    public Account getActualAccount(String passport, Account account) {
        Account result = null;
        try {
            result = this.map.entrySet().stream().filter(
                    object -> object.getKey().getPassport().equals(passport)
            ).map(
                    object -> object.getValue().get(object.getValue().indexOf(account))
            ).findAny().orElse(null);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Account not found");
        }
        return result;
    }

    /**
     * Finds a specific account by user's passport and requisites of an account.
     * @param passport - a user's passport
     * @param requisites - requisites of an account
     * @return true - if the operation successful, false - otherwise
     */
    public Account findAccountByPassportAndRequisites(String passport, String requisites) {
        return this.map.entrySet().stream().filter(
                e -> e.getKey().getPassport().equals(passport)
        ).flatMap(
                e -> e.getValue().stream()
        ).filter(
                e -> e.getRequisites().equals(requisites)
        ).findAny().orElse(null);
    }

    /**
     * Transfers money between accounts.
     * @param srcPassport - a source passport
     * @param srcRequisite - a source requisite
     * @param destPassport - a destination passport
     * @param dstRequisite - a destination requisite
     * @param amount - amount of money to be transferred
     * @return true - if the operation successful, false - otherwise
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = false;
        Account srcAcc = this.findAccountByPassportAndRequisites(srcPassport, srcRequisite);
        Account destAcc = this.findAccountByPassportAndRequisites(destPassport, dstRequisite);
        if (srcAcc != null && srcAcc.getValue() > amount && destAcc != null) {
            srcAcc.setDecreasedValue(amount);
            destAcc.setIncreasedValue(amount);
            result = true;
        }
        return result;
    }
}