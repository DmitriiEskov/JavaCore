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
    public List<Account> deleteUser(User user) {
        return this.map.remove(user);
    }

    /**
     * Adds a new account for a user.
     * @param user - a user
     * @param account - a user's account
     */
    public void addAccountToUser(User user, Account account) {
        this.map.get(user).add(account);
    }

    /**
     * Deletes a user's account.
     * @param user - a user
     * @param account - a user's account
     */
    public boolean deleteAccountFromUser(User user, Account account) {
        return this.map.get(user).remove(account);
    }

    /**
     * Returns all user's accounts.
     * @param user - a user
     * @return a list of user's accounts
     */
    public List<Account> getUserAccounts(User user) {
        return this.map.get(user);
    }

    /**
     * Returns a user's account.
     * @param user - a user
     * @return a user's account
     */
    private Account getActualAccount(User user, Account account) {
        List<Account> list = this.map.get(user);
        return list.get(list.indexOf(account));
    }

    /**
     * Transfers money between accounts.
     * @param user1 - user 1
     * @param account1 - user 1's account
     * @param user2 - user 2
     * @param account2 - user 2's account
     * @param amount - amount of money to be transferred
     * @return true - if  the transfer successful, false - otherwise
     */
    public boolean transferMoney(User user1, Account account1, User user2, Account account2, double amount) {
        return this.map.get(user1).contains(account1) && this.map.get(user2).contains(account2)
                && this.getActualAccount(user1, account1).transfer(this.getActualAccount(user2, account2), amount);
    }
}